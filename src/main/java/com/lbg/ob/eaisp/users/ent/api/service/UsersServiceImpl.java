package com.lbg.ob.eaisp.users.ent.api.service;

import com.lbg.ob.eaisp.users.ent.api.constants.ErrorConstants;
import com.lbg.ob.eaisp.users.ent.api.constants.Errors;
import com.lbg.ob.eaisp.users.ent.api.entities.UsersDetailsEntity;
import com.lbg.ob.eaisp.users.ent.api.exceptions.ConflictException;
import com.lbg.ob.eaisp.users.ent.api.model.User;
import com.lbg.ob.eaisp.users.ent.api.repository.UsersRepository;
import com.ob.eaisp.commons.constants.Brand;
import com.ob.eaisp.commons.exception.InternalServerErrorException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User saveUser(User user) {
        if (isConflictRecord(user))
            throw new ConflictException(ErrorConstants.RECORD_EXISTS_MESSAGE);
        UsersDetailsEntity userDetailsEntity = mapUserToUserDetailsEntity(user);
        usersRepository.save(userDetailsEntity);
        return user;
    }

    @Override
    public List<User> findAllUserDetails(String partyId, Brand brand, String tspId) {
        List<UsersDetailsEntity> users;
        if (tspId != null) {
            users = usersRepository.findAllByTspIdAndPartyIdAndBrand(tspId, partyId, brand);
            if (users.size() > 1)
                 // throw new InternalServerErrorException(ErrorConstants.MULTIPLE_DB_RECORDS_EXIST_MESSAGE);
                 throw new InternalServerErrorException(Errors.GET_MULTIPLE_DB_RECORDS_EXIST_MESSAGE.toError());
        } else users = usersRepository.findAllByPartyIdAndBrand(partyId, brand);
        return users.stream().map(usersDetails -> modelMapper.map(usersDetails, User.class)).toList();
    }

    private UsersDetailsEntity mapUserToUserDetailsEntity(User user) {
        UsersDetailsEntity userDetailsEntity = modelMapper.map(user, UsersDetailsEntity.class);
        userDetailsEntity.setCreationDateTime(LocalDateTime.now());
        userDetailsEntity.setUpdatedDateTime(LocalDateTime.now());
        return userDetailsEntity;
    }

    private boolean isConflictRecord(User user) {
        return !(usersRepository.findAllByTspIdAndPartyIdAndBrand(
                user.getTspId(), user.getPartyId(), user.getBrand())).isEmpty();
    }
}

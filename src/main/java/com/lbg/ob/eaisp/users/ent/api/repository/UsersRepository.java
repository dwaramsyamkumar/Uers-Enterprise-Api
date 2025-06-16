package com.lbg.ob.eaisp.users.ent.api.repository;


import com.lbg.ob.eaisp.users.ent.api.entities.UsersDetailsEntity;
import com.ob.eaisp.commons.constants.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersDetailsEntity, String> {

    List<UsersDetailsEntity> findAllByPartyIdAndBrand(
            String partyId, Brand brand);

   List<UsersDetailsEntity> findAllByTspIdAndPartyIdAndBrand(
           String tspId, String partyId, Brand brand);
}
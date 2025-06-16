package com.lbg.ob.eaisp.users.ent.api.service;

import com.lbg.ob.eaisp.users.ent.api.model.User;
import com.ob.eaisp.commons.constants.Brand;
import jakarta.validation.constraints.Size;

import java.util.List;

public interface UsersService {
   public User saveUser(User user);

   public List<User> findAllUserDetails(String partyId, Brand brand, String tspId);
}

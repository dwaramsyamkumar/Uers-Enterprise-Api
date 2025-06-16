package com.lbg.ob.eaisp.users.ent.api.controller;

import com.lbg.ob.eaisp.users.ent.api.model.User;
import com.lbg.ob.eaisp.users.ent.api.service.UsersService;
import com.ob.eaisp.commons.model.RequestContext;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/v1/users", produces = APPLICATION_JSON_VALUE)
@Slf4j
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/saveUserDetails")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUserDetails(
            @Parameter(hidden = true) RequestContext requestContext,
            @RequestBody() @Valid User user){
          log.debug("ENTITY: Controller method- saveUserDetails");
          return usersService.saveUser(user);
    }

    @GetMapping("/getUserDetails")
    public List<User> getUserDetails(
            @Parameter(hidden = true) RequestContext context,
            @RequestParam(name = "TspId", required = false)  @Size(min = 1, max = 40) String tspId){
        log.debug("ENTITY: Controller method- getUserDetails");
        return usersService.findAllUserDetails(context.getPartyId(),context.getBrand(),tspId);
    }
}
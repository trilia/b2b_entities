package com.trillia.controller;

import com.trillia.jpa.entities.Role;
import com.trillia.jpa.entities.UserRoleAssociation;
import com.trillia.jpa.entities.Users;
import com.trillia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by mmathew on 14/06/16.
 */
@Controller
//@Path("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Transactional
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/users")
    public List<Users> addUser(List<Users> users) {
        return userService.saveUsers(users);
    }


    @Transactional
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/roles")
    public List<Role> addRoles(List<Role> roles) {
        return userService.saveRoles(roles);
    }


    @Transactional
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/userrolesassociation")
    public List<UserRoleAssociation> addUserRoleAssociation(List<UserRoleAssociation> userRoleAssociationList) {
        return userService.saveUserRoleAssociation(userRoleAssociationList);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/roles/user/{id}")
    public List<Role> getRoles(@PathParam("id") String userid) {
        return userService.getRolesForUser(userid);
    }


}

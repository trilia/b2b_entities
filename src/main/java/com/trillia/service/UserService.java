package com.trillia.service;

import com.trillia.jpa.entities.Role;
import com.trillia.jpa.entities.Subscriber;
import com.trillia.jpa.entities.UserRoleAssociation;
import com.trillia.jpa.entities.Users;
import com.trillia.jpa.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmathew on 14/06/16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepositoryImpl rolesRepository;

    @Autowired
    private SubcriberRepository subcriberRepository;


    @Autowired
    //@Qualifier("userRoleAssociationRepository")
    private UsersRepository userRoleAssociationRepository;

    @Autowired
    private IUserRoleAssociationRepository iUserRoleAssociationRepository;


    public List<Users> saveUsers(List<Users> users) {
        List<Users> userRes = userRepository.save(users);
        userRepository.flush();
        return userRes;
    }


    public List<Subscriber> saveSubscribers(List<Subscriber> subscribers) {
        List<Subscriber> subscriberList = subcriberRepository.save(subscribers);
        subcriberRepository.flush();
        return subscriberList;

    }


    public List<Role> saveRoles(List<Role> roles) {
        List<Role> roleRes = roleRepository.save(roles);
        roleRepository.flush();
        return roleRes;
    }

    public List<UserRoleAssociation> saveUserRoleAssociation(List<UserRoleAssociation> userRoleAssociationList) {
        for (UserRoleAssociation userRoleAssociations : userRoleAssociationList) {
           try {
               iUserRoleAssociationRepository.save(userRoleAssociations);
               iUserRoleAssociationRepository.flush();
           }
           catch(Exception e)
           {

           }
           }
        return userRoleAssociationList;
    }


    public List<Role> getRolesForUser(String userID) {
        Users user = userRoleAssociationRepository.findUserRoleAssociationByUserId(Long.parseLong(userID));//ndOne(Long.parseLong(userID));
        List<UserRoleAssociation> userRoleAssociations = user.getUserRoleAssociationList();
        List<Role> roleList = new ArrayList<>();
        for (UserRoleAssociation userRoleAssociation : userRoleAssociations) {
            //        roleList.add(userRoleAssociation.getRoleId());
        }
        return roleList;

    }


    public List<Users> getUsers() {

        return usersRepository.getAllUsers();
    }


    public List<Role> getRoles() {
        return rolesRepository.getAllRoles();//Repository.findAll();
    }

    public List<Subscriber> getAllSubscriber() {
        return usersRepository.getAllSubscriber();
    }
}

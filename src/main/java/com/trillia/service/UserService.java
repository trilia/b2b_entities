package com.trillia.service;

import com.trillia.jpa.entities.Role;
import com.trillia.jpa.entities.UserRoleAssociation;
import com.trillia.jpa.entities.Users;
import com.trillia.jpa.repo.RoleRepository;
import com.trillia.jpa.repo.UserRepository;
import com.trillia.jpa.repo.IUserRoleAssociationRepository;
import com.trillia.jpa.repo.UserRoleAssociationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("userRoleAssociationRepository")
    private UserRoleAssociationRepositoryImpl userRoleAssociationRepository;

    @Autowired
    private IUserRoleAssociationRepository iUserRoleAssociationRepository;


    public List<Users> saveUsers(List<Users> users) {
        List<Users> userRes = userRepository.save(users);
        userRepository.flush();
        return userRes;
    }


    public List<Role> saveRoles(List<Role> roles) {
        List<Role> roleRes = roleRepository.save(roles);
        roleRepository.flush();
        return roleRes;
    }

    public List<UserRoleAssociation> saveUserRoleAssociation(List<UserRoleAssociation> userRoleAssociationList) {
        List<UserRoleAssociation> userRoleAssociations = iUserRoleAssociationRepository.save(userRoleAssociationList);
        iUserRoleAssociationRepository.flush();
        return userRoleAssociations;
    }


    public List<Role> getRolesForUser(String userID) {
        List<UserRoleAssociation> userRoleAssociations = userRoleAssociationRepository.findUserRoleAssociationByUserId(Long.parseLong(userID));
        List<Role> roleList = new ArrayList<>();
        for (UserRoleAssociation userRoleAssociation : userRoleAssociations) {
            roleList.add(userRoleAssociation.getRoleId());
        }
        return roleList;

    }


}

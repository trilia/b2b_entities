package com.trillia.service;

import com.trillia.jpa.entities.UserRoleAssociation;
import com.trillia.jpa.repo.IUserRoleAssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by mmathew on 05/06/16.
 */

@WebService(endpointInterface = "com.trillia.service.IRoleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IUserRoleAssociationRepository userRoleAssociationRepository;

    @Override
    public String[] getRoles(long userID) {
        List<UserRoleAssociation> userRoleAssociation = userRoleAssociationRepository.findUserRoleAssociationByUserId(userID);
        return new String[0];
    }
}

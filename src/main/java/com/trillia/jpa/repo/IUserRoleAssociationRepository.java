package com.trillia.jpa.repo;

import com.trillia.jpa.entities.Role;
import com.trillia.jpa.entities.UserRoleAssociation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mmathew on 05/06/16.
 */
@Repository
public  interface IUserRoleAssociationRepository extends ResourceRepository<UserRoleAssociation> {


    List<UserRoleAssociation> findUserRoleAssociationByUserId(@Param("userId") long userId);
}

package com.trillia.jpa.repo;

import com.trillia.jpa.entities.Role;
import com.trillia.jpa.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by mmathew on 23/06/16.
 */
@Repository
public class RolesRepositoryImpl {



    @Autowired
    private EntityManagerFactory entityManagerFactory;



    public List<Role> getAllRoles() {
        TypedQuery<Role> query = entityManagerFactory.createEntityManager().createNamedQuery("Role.findAllRoles", Role.class);
        return query.getResultList();//getSingleResult();
    }
}

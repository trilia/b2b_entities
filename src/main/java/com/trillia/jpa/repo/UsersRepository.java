package com.trillia.jpa.repo;

import com.olp.jpa.common.AbstractRepositoryImpl;
import com.trillia.jpa.entities.Subscriber;
import com.trillia.jpa.entities.UserRoleAssociation;
import com.trillia.jpa.entities.Users;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

import java.util.List;

/**
 * Created by mmathew on 18/06/16.
 */

@Repository()
public class UsersRepository {


    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public Users findUserRoleAssociationByUserId(@Param("userId") long userId) {

        TypedQuery<Users> query = entityManagerFactory.createEntityManager().createNamedQuery("Users.findByUser", Users.class);
        query.setParameter("id", userId);
        //List res = query.getSingleResult();


        return query.getSingleResult();
    }

    public List<Users> getAllUsers() {
        TypedQuery<Users> query = entityManagerFactory.createEntityManager().createNamedQuery("Users.findAllUser", Users.class);


        return query.getResultList();//getSingleResult();
    }




    public List<Subscriber> getAllSubscriber()
    {
        TypedQuery<Subscriber> query = entityManagerFactory.createEntityManager().createNamedQuery("Subscriber.findAllSubscriber", Subscriber.class);


        return query.getResultList();//getSingleResult();
    }

}

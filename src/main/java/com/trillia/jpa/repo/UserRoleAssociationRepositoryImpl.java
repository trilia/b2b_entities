package com.trillia.jpa.repo;

import com.olp.jpa.common.AbstractRepositoryImpl;
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
@NamedQueries({
        @NamedQuery(name="UserRoleAssociation.findByUser", query="SELECT t from UserRoleAssociation t join fetch t.userId WHERE t.userId = :id")
})
@Repository("userRoleAssociationRepository")
public class UserRoleAssociationRepositoryImpl {


    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public List<UserRoleAssociation> findUserRoleAssociationByUserId(@Param("userId") long userId) {

//        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManagerFactory.createEntityManager());
//        Users users = new Users();
//        users.setId(userId);
//        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(UserRoleAssociation.class).get();
//        org.apache.lucene.search.Query query = queryBuilder.bool().must(queryBuilder.keyword().onField("userId").matching(users).createQuery()).createQuery();
//        //  fullTextEntityManager.cre
//
//        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, UserRoleAssociation.class);
//        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
//        List<UserRoleAssociation> userRoleAssociations = fullTextQuery.getResultList();
//        Query query = entityManagerFactory.createEntityManager().createNativeQuery("db.getCollection('trl_user_role_associations').find({user_id:766})", UserRoleAssociation.class);
//        //   query.setParameter("userId", userId); // TODO: Sanitize input, although low risk due to binding
//
//
//        //query.setHint("javax.persistence.fetchgraph", graph); // Entity graph is not supported yet in OGM
//
//        List<UserRoleAssociation> resultList = query.getResultList();
//
//        //if (bean != null && bean.getEmployees() != null)
//        //    bean.getEmployees().size(); // Apparently no way to avoid loading child entity instances, hence EAGER loading


        TypedQuery<UserRoleAssociation> query = entityManagerFactory.createEntityManager().createNamedQuery("UserRoleAssociation.findByUser",UserRoleAssociation.class);
        query.setParameter("id",userId);
        List res = query.getResultList();


        return res;
    }


}

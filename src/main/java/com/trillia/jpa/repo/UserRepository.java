package com.trillia.jpa.repo;

import com.trillia.jpa.entities.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by mmathew on 14/06/16.
 */
@NamedQueries({
        @NamedQuery(name="Users.findByUser", query="SELECT t from Users t  WHERE t.userId = :id")
})
@Repository
public interface UserRepository extends ResourceRepository<Users> {





}

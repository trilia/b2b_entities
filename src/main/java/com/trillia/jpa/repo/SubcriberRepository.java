package com.trillia.jpa.repo;

import com.trillia.jpa.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mmathew on 23/06/16.
 */
@Repository
public interface SubcriberRepository extends JpaRepository<Subscriber,String> {
}

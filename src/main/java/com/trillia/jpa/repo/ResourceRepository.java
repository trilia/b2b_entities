package com.trillia.jpa.repo;


import com.trillia.jpa.entities.RevisionControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by mmathew on 05/06/16.
 */
@NoRepositoryBean
public interface ResourceRepository<T extends RevisionControl> extends JpaRepository<T,Long> {
}

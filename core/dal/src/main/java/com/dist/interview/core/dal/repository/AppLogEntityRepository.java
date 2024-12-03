package com.dist.interview.core.dal.repository;

import com.dist.interview.core.dal.entity.AppLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppLogEntityRepository extends JpaRepository<AppLogEntity, Long> {
}

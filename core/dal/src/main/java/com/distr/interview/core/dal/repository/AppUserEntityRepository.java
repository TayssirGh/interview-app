package com.distr.interview.core.dal.repository;

import com.distr.interview.core.dal.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserEntityRepository extends JpaRepository<AppUserEntity, Long> {
  Optional<AppUserEntity> findByUsername(String username);
  Optional<AppUserEntity> findByUsernameOrEmail(String username, String email);
}

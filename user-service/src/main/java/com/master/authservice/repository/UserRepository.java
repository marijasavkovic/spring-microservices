package com.master.authservice.repository;

import java.util.Optional;

import com.master.authservice.domain.UserEntity;
import com.master.authservice.sheard.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    @Query("SELECT u FROM UserEntity u WHERE LOWER(u.username) = LOWER(:username)")
    UserEntity findByUsernameCaseInsensitive(@Param("username") String username);

}

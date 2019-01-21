package com.master.userservice.repository;

import java.util.Optional;

import com.master.userservice.domain.UserEntity;
import com.master.userservice.sheard.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    @Query("SELECT u FROM UserEntity u WHERE LOWER(u.username) = LOWER(:username)")
    UserEntity findByUsernameCaseInsensitive(@Param("username") String username);

}

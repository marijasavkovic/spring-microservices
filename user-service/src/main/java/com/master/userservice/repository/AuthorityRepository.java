package com.master.userservice.repository;

import com.master.userservice.domain.AuthorityEntity;
import com.master.userservice.sheard.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends BaseRepository<AuthorityEntity, Long>{
}

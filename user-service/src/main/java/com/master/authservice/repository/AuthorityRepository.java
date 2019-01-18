package com.master.authservice.repository;

import com.master.authservice.domain.AuthorityEntity;
import com.master.authservice.sheard.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends BaseRepository<AuthorityEntity, Long>{
}

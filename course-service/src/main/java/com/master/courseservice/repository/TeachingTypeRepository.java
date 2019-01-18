package com.master.courseservice.repository;

import com.master.courseservice.domain.TeachingTypeEntity;
import com.master.courseservice.sheard.repository.BaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface TeachingTypeRepository extends BaseRepository<TeachingTypeEntity, Long> {}

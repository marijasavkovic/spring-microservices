package com.master.levelofstudiesservice.repository;

import com.master.levelofstudiesservice.domain.LevelOfStudiesEntity;
import com.master.levelofstudiesservice.sheard.repository.BaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface LevelOfStudiesRepository extends BaseRepository<LevelOfStudiesEntity, Long> {}

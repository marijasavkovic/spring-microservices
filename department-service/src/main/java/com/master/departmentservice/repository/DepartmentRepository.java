package com.master.departmentservice.repository;

import com.master.departmentservice.domain.DepartmentEntity;
import com.master.departmentservice.sheard.repository.BaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface DepartmentRepository extends BaseRepository<DepartmentEntity, Long> {
}

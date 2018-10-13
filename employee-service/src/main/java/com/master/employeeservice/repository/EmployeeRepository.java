package com.master.employeeservice.repository;

import com.master.employeeservice.domain.EmployeeEntity;
import com.master.employeeservice.sheard.repository.BaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface EmployeeRepository extends BaseRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByPersonalIdentificationNumber(String personalIdentificationNumber);

}

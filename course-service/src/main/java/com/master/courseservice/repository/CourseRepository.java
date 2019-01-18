package com.master.courseservice.repository;

import java.util.List;
import java.util.Optional;

import com.master.courseservice.domain.CourseEntity;
import com.master.courseservice.sheard.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends BaseRepository<CourseEntity, Long> {

    @Query(
        "select c from CourseEntity c left join c.lecturerList l where l.employeeId = ?1 ")
    List<CourseEntity> findByEmployeeId(Long employeeId);

    Optional<CourseEntity> findByName(String name);
}

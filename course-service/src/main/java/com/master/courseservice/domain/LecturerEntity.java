package com.master.courseservice.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.master.courseservice.sheard.domain.BaseEntity;

@Entity
@Table(name = "lecturer")
public class LecturerEntity extends BaseEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "teaching_type_id")
    private TeachingTypeEntity teachingType;

    @Column(name = "employee_id")
    private Long employeeId;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(final CourseEntity course) {
        setCourse(course, true);
    }

    void setCourse(CourseEntity course, boolean add) {
        this.course = course;
        if (course != null && add) {
            course.addLecturer(this, false);
        }
    }

    public TeachingTypeEntity getTeachingType() {
        return teachingType;
    }

    public void setTeachingType(final TeachingTypeEntity teachingType) {
        this.teachingType = teachingType;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
            .append("id")
            .append(id)
            .append("employee")
            .append(employeeId)
            .append("course")
            .append(course.getName())
            .append("teaching type")
            .append(teachingType.getName())
            .toString();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof LecturerEntity) {
            LecturerEntity lecturerEntity = (LecturerEntity) obj;
            if (lecturerEntity.getTeachingType() != null && lecturerEntity.getEmployeeId() != null) {
                if (lecturerEntity.getTeachingType().equals(teachingType) && lecturerEntity.getEmployeeId().equals(employeeId)) {
                    return true;
                }
            }
        }
        return false;
    }
}

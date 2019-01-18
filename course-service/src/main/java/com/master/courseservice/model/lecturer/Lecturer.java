package com.master.courseservice.model.lecturer;

import java.io.Serializable;

import com.master.courseservice.model.teachingtype.TeachingType;

public class Lecturer implements Serializable {

    private Long id;
    private TeachingType teachingType;
    private Long employeeId;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public TeachingType getTeachingType() {
        return teachingType;
    }

    public void setTeachingType(final TeachingType teachingType) {
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
            .append("teaching type")
            .append(teachingType.getName()).toString();
    }
}

package com.master.apigatewayservice.model.course.lecturer;

import java.io.Serializable;

import com.master.apigatewayservice.model.course.teachingtype.TeachingType;
import com.master.apigatewayservice.model.employee.Employee;

public class Lecturer implements Serializable {

    private Long id;
    private TeachingType teachingType;
    private Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
            .append("id")
            .append(id)
            .append("employee")
            .append(employee.getName())
            .append("teaching type")
            .append(teachingType.getName()).toString();
    }
}

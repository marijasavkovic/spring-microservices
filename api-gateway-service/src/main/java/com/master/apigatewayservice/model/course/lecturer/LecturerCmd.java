package com.master.apigatewayservice.model.course.lecturer;

import java.io.Serializable;

public class LecturerCmd implements Serializable {

    private Long id;
    private Long teachingTypeId;
    private Long employeeId;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getTeachingTypeId() {
        return teachingTypeId;
    }

    public void setTeachingTypeId(final Long teachingTypeId) {
        this.teachingTypeId = teachingTypeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
            .append("id")
            .append(id)
            .append("employee id")
            .append(employeeId)
            .append("teaching type id")
            .append(teachingTypeId)
            .toString();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof LecturerCmd) {
            LecturerCmd lecturerCmd = (LecturerCmd) obj;
            if (lecturerCmd.getTeachingTypeId() != null && lecturerCmd.getEmployeeId() != null) {
                return lecturerCmd.getTeachingTypeId().equals(teachingTypeId) && lecturerCmd
                    .getEmployeeId()
                    .equals(employeeId);
            }
        }
        return false;
    }
}

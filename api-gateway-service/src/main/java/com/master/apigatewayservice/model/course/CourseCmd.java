package com.master.apigatewayservice.model.course;

import java.io.Serializable;
import java.util.List;

import com.master.apigatewayservice.model.course.lecturer.LecturerCmd;
import com.master.apigatewayservice.model.course.thematicunit.ThematicUnitCmd;

public class CourseCmd implements Serializable{

    private Long id;
    private String name;
    private int espb;
    private String goal;
    private String methodOfEvaluation;
    private Long levelOfStudiesId;
    private Long departmentId;
    private List<LecturerCmd> lecturerList;
    private List<ThematicUnitCmd> thematicUnitsList;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(final int espb) {
        this.espb = espb;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(final String goal) {
        this.goal = goal;
    }

    public String getMethodOfEvaluation() {
        return methodOfEvaluation;
    }

    public void setMethodOfEvaluation(final String methodOfEvaluation) {
        this.methodOfEvaluation = methodOfEvaluation;
    }

    public Long getLevelOfStudiesId() {
        return levelOfStudiesId;
    }

    public void setLevelOfStudiesId(final Long levelOfStudiesId) {
        this.levelOfStudiesId = levelOfStudiesId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(final Long departmentId) {
        this.departmentId = departmentId;
    }

    public List<LecturerCmd> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(final List<LecturerCmd> lecturerList) {
        this.lecturerList = lecturerList;
    }

    public List<ThematicUnitCmd> getThematicUnitsList() {
        return thematicUnitsList;
    }

    public void setThematicUnitsList(final List<ThematicUnitCmd> thematicUnitsList) {
        this.thematicUnitsList = thematicUnitsList;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
            .append("id")
            .append(id)
            .append("name")
            .append(name).toString();
    }
}

package com.master.apigatewayservice.model.course;

import java.io.Serializable;
import java.util.List;

import com.master.apigatewayservice.model.course.lecturer.Lecturer;
import com.master.apigatewayservice.model.course.thematicunit.ThematicUnit;
import com.master.apigatewayservice.model.department.Department;
import com.master.apigatewayservice.model.levelofstudies.LevelOfStudies;

public class Course implements Serializable {

    private Long id;
    private String name;
    private int espb;
    private String goal;
    private String methodOfEvaluation;
    private LevelOfStudies levelOfStudies;
    private Department department;
    private List<Lecturer> lecturerList;
    private List<ThematicUnit> thematicUnitsList;

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

    public LevelOfStudies getLevelOfStudies() {
        return levelOfStudies;
    }

    public void setLevelOfStudies(final LevelOfStudies levelOfStudies) {
        this.levelOfStudies = levelOfStudies;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(final Department department) {
        this.department = department;
    }

    public List<Lecturer> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(final List<Lecturer> lecturerList) {
        this.lecturerList = lecturerList;
    }

    public List<ThematicUnit> getThematicUnitsList() {
        return thematicUnitsList;
    }

    public void setThematicUnitsList(final List<ThematicUnit> thematicUnitsList) {
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

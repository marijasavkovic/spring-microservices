package com.master.courseservice.model.course;

import java.io.Serializable;
import java.util.List;

import com.master.courseservice.model.lecturer.Lecturer;
import com.master.courseservice.model.thematicunit.ThematicUnit;

public class Course implements Serializable {

    private Long id;
    private String name;
    private int espb;
    private String goal;
    private String methodOfEvaluation;
    private Long levelOfStudiesId;
    private Long departmentId;
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

    public Long getLevelOfStudiesId() {
        return levelOfStudiesId;
    }

    public void setLevelOfStudiesId(Long levelOfStudiesId) {
        this.levelOfStudiesId = levelOfStudiesId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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

package com.master.courseservice.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import com.master.courseservice.sheard.domain.BaseEntity;

@Entity
@Table(name = "course")
public class CourseEntity extends BaseEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "espb", nullable = false)
    private int espb;

    @Column(name = "goal", nullable = false)
    private String goal;

    @Column(name = "method_of_evaluation", nullable = false)
    private String methodOfEvaluation;

    @Column(name = "level_of_studies_id", nullable = false)
    private Long levelOfStudiesId;

    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "course", orphanRemoval = true)
    private List<LecturerEntity> lecturerList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "course", orphanRemoval = true)
    private List<ThematicUnitEntity> thematicUnitsList;

    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    public List<LecturerEntity> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(final List<LecturerEntity> lecturerList) {
        this.lecturerList = lecturerList;
    }

    public List<ThematicUnitEntity> getThematicUnitsList() {
        return thematicUnitsList;
    }

    public void setThematicUnitsList(final List<ThematicUnitEntity> thematicUnitsList) {
        this.thematicUnitsList = thematicUnitsList;
    }

    public void addLecturer(LecturerEntity lecturerEntity) {
        addLecturer(lecturerEntity, true);
    }

    void addLecturer(LecturerEntity lecturerEntity, boolean set) {
        if (lecturerEntity != null) {
            if(getLecturerList().contains(lecturerEntity)) {
                getLecturerList().set(getLecturerList().indexOf(lecturerEntity), lecturerEntity);
            }
            else {
                getLecturerList().add(lecturerEntity);
            }
            if (set) {
                lecturerEntity.setCourse(this, false);
            }
        }
    }

    public void removeLecturer(LecturerEntity lecturerEntity) {
        getLecturerList().remove(lecturerEntity);
        lecturerEntity.setCourse(null);
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
            .append("id")
            .append(id)
            .append("name")
            .append(name)
            .append("department")
            .append(departmentId)
            .toString();
    }

}

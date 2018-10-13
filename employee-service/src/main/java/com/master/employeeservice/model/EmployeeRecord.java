package com.master.employeeservice.model;

import com.master.employeeservice.domain.EmployeeTitle;
import com.master.employeeservice.domain.EmployeeVocation;

import java.io.Serializable;
import java.util.Date;

public class EmployeeRecord implements Serializable{

    private Long id;
    private String name;
    private String surname;
    private String personalIdentificationNumber;
    private Date dateOfEmployment;
    private EmployeeTitle title;
    private EmployeeVocation vocation;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    public void setPersonalIdentificationNumber(final String personalIdentificationNumber) {
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(final Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public EmployeeTitle getTitle() {
        return title;
    }

    public void setTitle(final EmployeeTitle title) {
        this.title = title;
    }

    public EmployeeVocation getVocation() {
        return vocation;
    }

    public void setVocation(final EmployeeVocation vocation) {
        this.vocation = vocation;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
            .append("id")
            .append(id)
            .append("name")
            .append(name)
            .append("surname")
            .append(surname).toString();
    }
}

package com.master.apigatewayservice.model.course.thematicunit;

import java.io.Serializable;

public class ThematicUnitCmd implements Serializable {

    private Long id;
    private String name;
    private String serialNumber;
    private String description;
    private String parentThematicUnitSerialNumber;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(final String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getParentThematicUnitSerialNumber() {
        return parentThematicUnitSerialNumber;
    }

    public void setParentThematicUnitSerialNumber(final String parentThematicUnitSerialNumber) {
        this.parentThematicUnitSerialNumber = parentThematicUnitSerialNumber;
    }

    @Override
    public String toString() {
        return "ThematicUnit{" + "id=" + id + ", name='" + name + '\'' + ", serialNumber='" + serialNumber + '\''
            + ", description='" + description + '\'' + ", parentThematicUnit=" + parentThematicUnitSerialNumber + '}';
    }
}

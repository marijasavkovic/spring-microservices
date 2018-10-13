package com.master.departmentservice.facade;

import com.master.departmentservice.model.Department;
import com.master.departmentservice.sheard.response.Response;

import java.util.List;

public interface Facade {

    Response<List<Department>> findAllDepartments();
}

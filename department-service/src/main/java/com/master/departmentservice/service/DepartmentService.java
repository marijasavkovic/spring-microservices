package com.master.departmentservice.service;

import com.master.departmentservice.model.Department;
import com.master.departmentservice.sheard.response.Response;

import java.util.List;

public interface DepartmentService {
    Response<List<Department >> findAll();
}

package com.master.departmentservice.facade.impl;

import com.master.departmentservice.facade.Facade;
import com.master.departmentservice.model.Department;
import com.master.departmentservice.service.DepartmentService;
import com.master.departmentservice.sheard.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class FacadeImpl implements Facade {

    private final DepartmentService departmentService;

    @Autowired
    public FacadeImpl(
        final DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    @Override
    @GetMapping("department/findAllDepartments")
    public Response<List<Department>> findAllDepartments() {
        return departmentService.findAll();
    }

}

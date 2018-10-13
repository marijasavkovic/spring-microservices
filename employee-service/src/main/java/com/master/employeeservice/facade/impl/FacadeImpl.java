package com.master.employeeservice.facade.impl;

import com.master.employeeservice.facade.Facade;
import com.master.employeeservice.model.Employee;
import com.master.employeeservice.model.EmployeeCmd;
import com.master.employeeservice.model.EmployeeRecord;
import com.master.employeeservice.service.EmployeeService;
import com.master.employeeservice.sheard.response.Response;
import com.master.employeeservice.sheard.validation.ValidationGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class FacadeImpl implements Facade {

    private final EmployeeService employeeService;

    @Autowired
    public FacadeImpl(
        final EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @Override
    @GetMapping("employee/findAllEmployees")
    public Response<List<EmployeeRecord>> findAllEmployees() {
        return employeeService.findAll();
    }

    @Override
    @GetMapping("employee/{employeeId}")
    public Response<Employee> findEmployeeById(@PathVariable Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @Override
    @PostMapping("employee")
    public Response<Employee> addEmployee(@Validated(ValidationGroups.Add.class) @RequestBody EmployeeCmd employeeCmd) {
        return employeeService.add(employeeCmd);
    }

    @Override
    @PutMapping("employee/{employeeId}")
    public Response<Employee> editEmployee(@PathVariable Long employeeId, @Validated(ValidationGroups.Edit.class) @RequestBody EmployeeCmd employeeCmd) {
        return employeeService.edit(employeeId, employeeCmd);
    }
}

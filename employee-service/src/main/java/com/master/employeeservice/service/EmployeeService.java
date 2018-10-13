package com.master.employeeservice.service;

import com.master.employeeservice.model.Employee;
import com.master.employeeservice.model.EmployeeCmd;
import com.master.employeeservice.model.EmployeeRecord;
import com.master.employeeservice.sheard.response.Response;

import java.util.List;

public interface EmployeeService {

    Response<List<EmployeeRecord>> findAll();

    Response<Employee> findById(Long id);

    Response<Employee> add(EmployeeCmd employeeCmd);

    Response<Employee> edit(Long employeeId, EmployeeCmd employeeCmd);

    Response<?> delete(Long employeeId);
}

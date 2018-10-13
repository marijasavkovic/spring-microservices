package com.master.employeeservice.facade;

import com.master.employeeservice.model.Employee;
import com.master.employeeservice.model.EmployeeCmd;
import com.master.employeeservice.model.EmployeeRecord;
import com.master.employeeservice.sheard.response.Response;

import java.util.List;

public interface Facade {

    Response<List<EmployeeRecord>> findAllEmployees();

    Response<Employee> findEmployeeById(Long id);

    Response<Employee> addEmployee(EmployeeCmd employeeCmd);

    Response<Employee> editEmployee(Long employeeId, EmployeeCmd employeeCmd);

}

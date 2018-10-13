package com.master.employeeservice.service.impl;

import com.master.employeeservice.domain.EmployeeEntity;
import com.master.employeeservice.mapper.EmployeeMapper;
import com.master.employeeservice.model.Employee;
import com.master.employeeservice.model.EmployeeCmd;
import com.master.employeeservice.model.EmployeeRecord;
import com.master.employeeservice.repository.EmployeeRepository;
import com.master.employeeservice.service.EmployeeService;
import com.master.employeeservice.sheard.response.Response;
import com.master.employeeservice.sheard.response.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
//    private final EmployeeValidator.Add employeeValidatorAdd;
//    private final EmployeeValidator.Edit employeeValidatorEdit;
//    private final EmployeeValidator.Delete employeeValidatorDelete;

    @Autowired
    public EmployeeServiceImpl(final EmployeeRepository employeeRepository,
                               final EmployeeMapper employeeMapper
//                               final EmployeeValidator.Add employeeValidatorAdd,
//                               final EmployeeValidator.Edit employeeValidatorEdit,
//                               final EmployeeValidator.Delete employeeValidatorDelete
    ) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
//        this.employeeValidatorAdd = employeeValidatorAdd;
//        this.employeeValidatorEdit = employeeValidatorEdit;
//        this.employeeValidatorDelete = employeeValidatorDelete;
    }

    @Override
    public Response<List<EmployeeRecord>> findAll() {
        return new Response<>(employeeMapper.mapToModelList(employeeRepository.findAll()));
    }

    @Override
    public Response<Employee> findById(final Long id) {
        Optional<Employee> employee = employeeRepository.findById(id).map(employeeMapper::mapToModel);
        return employee.map(Response::new).orElse(new Response<>(ResponseStatus.NOT_FOUND));
    }

    @Override
    public Response<Employee> add(final EmployeeCmd employeeCmd) {
        return new Response<>(addEmployee(employeeCmd));
    }

    @Override
    public Response<Employee> edit(final Long employeeId, final EmployeeCmd employeeCmd) {
        return new Response<>(editEmployee(employeeId, employeeCmd));
    }

    @Override
    public Response<?> delete(final Long employeeId) {
//        employeeValidatorDelete.validate(employeeId);
        employeeRepository.deleteById(employeeId);
        return new Response<>(ResponseStatus.OK, "Employee is deleted successfully!");
    }

    private Employee addEmployee (EmployeeCmd employeeCmd) {
//        employeeValidatorAdd.validate(employeeCmd);

        EmployeeEntity employeeEntity = employeeMapper.mapToEntity(employeeCmd);
        return employeeMapper.mapToModel(employeeRepository.save(employeeEntity));
    }

    private Employee editEmployee (Long employeeId, EmployeeCmd employeeCmd){
//        employeeValidatorEdit.validate(employeeId, employeeCmd);

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                                                          .orElseThrow(RuntimeException::new);

        employeeMapper.updateEntityFromModel(employeeCmd, employeeEntity);
        return employeeMapper.mapToModel(employeeRepository.save(employeeEntity));
    }
}

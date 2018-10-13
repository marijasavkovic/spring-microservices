package com.master.departmentservice.service.impl;

import com.master.departmentservice.mapper.DepartmentMapper;
import com.master.departmentservice.model.Department;
import com.master.departmentservice.repository.DepartmentRepository;
import com.master.departmentservice.service.DepartmentService;
import com.master.departmentservice.sheard.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(
        final DepartmentRepository departmentRepository, final DepartmentMapper departmentMapper)
    {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public Response<List<Department>> findAll() {

        return new Response<>(departmentMapper.mapToModelList(departmentRepository.findAll()));
    }
}

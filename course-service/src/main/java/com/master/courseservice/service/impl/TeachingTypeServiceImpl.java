package com.master.courseservice.service.impl;

import java.util.List;

import com.master.courseservice.mapper.TeachingTypeMapper;
import com.master.courseservice.model.teachingtype.TeachingType;
import com.master.courseservice.repository.TeachingTypeRepository;
import com.master.courseservice.service.TeachingTypeService;
import com.master.courseservice.sheard.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeachingTypeServiceImpl implements TeachingTypeService {

    private final TeachingTypeRepository teachingTypeRepository;
    private final TeachingTypeMapper teachingTypeMapper;

    @Autowired
    public TeachingTypeServiceImpl(final TeachingTypeRepository teachingTypeRepository,
                                    final TeachingTypeMapper teachingTypeMapper) {
        this.teachingTypeRepository = teachingTypeRepository;
        this.teachingTypeMapper = teachingTypeMapper;
    }

    @Override
    public Response<List<TeachingType>> findAll() {
        return new Response<>(teachingTypeMapper.mapToModelList(teachingTypeRepository.findAll()));
    }
}

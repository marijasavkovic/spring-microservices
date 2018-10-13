package com.master.levelofstudiesservice.service.impl;

import com.master.levelofstudiesservice.mapper.LevelOfStudiesMapper;
import com.master.levelofstudiesservice.model.LevelOfStudies;
import com.master.levelofstudiesservice.repository.LevelOfStudiesRepository;
import com.master.levelofstudiesservice.service.LevelOfStudiesService;
import com.master.levelofstudiesservice.sheard.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LevelOfStudiesServiceImpl implements LevelOfStudiesService{

    private final LevelOfStudiesRepository levelOfStudiesRepository;
    private final LevelOfStudiesMapper levelOfStudiesMapper;

    @Autowired
    public LevelOfStudiesServiceImpl(final LevelOfStudiesRepository levelOfStudiesRepository,
                                        final LevelOfStudiesMapper levelOfStudiesMapper) {
        this.levelOfStudiesRepository = levelOfStudiesRepository;
        this.levelOfStudiesMapper = levelOfStudiesMapper;
    }

    @Override
    public Response<List<LevelOfStudies>> findAll() {
        return new Response<>(levelOfStudiesMapper.mapToModelList(levelOfStudiesRepository.findAll()));
    }
}

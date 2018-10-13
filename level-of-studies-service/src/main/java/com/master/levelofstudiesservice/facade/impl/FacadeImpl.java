package com.master.levelofstudiesservice.facade.impl;

import com.master.levelofstudiesservice.facade.Facade;
import com.master.levelofstudiesservice.model.LevelOfStudies;
import com.master.levelofstudiesservice.service.LevelOfStudiesService;
import com.master.levelofstudiesservice.sheard.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class FacadeImpl implements Facade {

    private final LevelOfStudiesService levelOfStudiesService;

    @Autowired
    public FacadeImpl(
        final LevelOfStudiesService levelOfStudiesService)
    {
        this.levelOfStudiesService = levelOfStudiesService;
    }

    @Override
    @GetMapping("levelOfStudies/findAllLevelsOfStudies")
    public Response<List<LevelOfStudies>> findAllLevelOfStudies() {
        return levelOfStudiesService.findAll();
    }
}

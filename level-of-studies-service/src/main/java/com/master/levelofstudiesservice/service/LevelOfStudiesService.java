package com.master.levelofstudiesservice.service;

import com.master.levelofstudiesservice.model.LevelOfStudies;
import com.master.levelofstudiesservice.sheard.response.Response;

import java.util.List;

public interface LevelOfStudiesService {
    Response<List<LevelOfStudies>> findAll();
}

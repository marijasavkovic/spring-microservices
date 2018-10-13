package com.master.levelofstudiesservice.facade;

import com.master.levelofstudiesservice.model.LevelOfStudies;
import com.master.levelofstudiesservice.sheard.response.Response;

import java.util.List;

public interface Facade {

    Response<List<LevelOfStudies>> findAllLevelOfStudies();

}

package com.master.courseservice.service;

import java.util.List;

import com.master.courseservice.model.teachingtype.TeachingType;
import com.master.courseservice.sheard.response.Response;

public interface TeachingTypeService {
    Response<List<TeachingType>> findAll();
}

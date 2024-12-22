package org.example.poly.service;

import org.example.poly.model.response.CourseCategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseCategoryService {
    List<CourseCategoryResponse> getAllCourseCategory();
    CourseCategoryResponse getById(Integer courseCategoryId );
}

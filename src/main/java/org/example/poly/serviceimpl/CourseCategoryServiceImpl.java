package org.example.poly.serviceimpl;

import org.example.poly.mapper.CourseCategoryMapper;
import org.example.poly.model.entity.CourseCategory;
import org.example.poly.model.response.CourseCategoryResponse;
import org.example.poly.repo.CourseCategoryRepo;
import org.example.poly.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Autowired
    private CourseCategoryRepo courseCategoryRepo;
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;
    @Override
    public List<CourseCategoryResponse> getAllCourseCategory() {
        List<CourseCategory> courseCategories = courseCategoryRepo.findAll();
        return courseCategories.stream()
                .map(courseCategoryMapper :: convertEnToRes)
                .collect(Collectors.toList());
    }

    @Override
    public CourseCategoryResponse getById(Integer courseCategoryId) {
        return null;
    }
}

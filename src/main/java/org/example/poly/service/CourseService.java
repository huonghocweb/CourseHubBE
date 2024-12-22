package org.example.poly.service;

import org.example.poly.model.request.CourseRequest;
import org.example.poly.model.response.CourseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    Page<CourseResponse> getAllCourse(Pageable pageable);
    CourseResponse getCourseById(Integer courseId);
    CourseResponse createCourse(CourseRequest courseRequest);
    CourseResponse updateCourse(Integer courseId, CourseRequest courseRequest);
}

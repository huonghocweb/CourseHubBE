package org.example.poly.serviceimpl;

import jakarta.persistence.EntityNotFoundException;

import org.example.poly.mapper.CourseMapper;
import org.example.poly.model.entity.Course;
import org.example.poly.model.request.CourseRequest;
import org.example.poly.model.response.CourseResponse;
import org.example.poly.repo.*;
import org.example.poly.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.example.poly.model.entity.ReviewCourse;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseCategoryRepo courseCategoryRepo;
    @Autowired
    private CourseLevelRepo courseLevelRepo;
    @Autowired
    private CourseLanguageRepo courseLanguageRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EnrollmentRepo enrollmentRepo;
    @Autowired
    private ReviewCourseRepo reviewCourseRepo;

    @Override
    public Page<CourseResponse> getAllCourse(Pageable pageable) {
        Page<Course> coursePage = courseRepo.findAll(pageable);
        System.out.println(coursePage.getContent().get(0).getCourseTitle());
        List<CourseResponse> courseResponses = coursePage.getContent().stream()
                .map(courseMapper :: convertEnToRes)
                .collect(Collectors.toList());
                courseResponses.forEach(courseRes -> {
                        System.out.println("TOTAL USER " +reviewCourseRepo.avgReviewByCourseId(courseRes.getCourseId()) );
                        courseRes.setAvgReview(reviewCourseRepo.avgReviewByCourseId(courseRes.getCourseId()));
                        courseRes.setTotalUser(enrollmentRepo.countUserByCourseId(courseRes.getCourseId()));
                });
        System.out.println("Size : " + courseResponses.size());
        System.out.println(courseResponses.get(0).getCourseTitle());
        return new PageImpl<>(courseResponses, pageable , coursePage.getTotalElements());
    }

    @Override
    public CourseResponse getCourseById(Integer courseId) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("not found Course"));
                CourseResponse courseResponse =courseMapper.convertEnToRes(course);
                courseResponse.setAvgReview(reviewCourseRepo.avgReviewByCourseId(courseResponse.getCourseId()));
                courseResponse.setTotalUser(enrollmentRepo.countUserByCourseId(courseResponse.getCourseId()));
        return courseResponse;
    }

    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {
        Course course = courseMapper.convertReqToEn(courseRequest);
        course.setCourseCategory(courseCategoryRepo.findById(courseRequest.getCourseCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("not found Course Category")));
        course.setCourseLevel(courseLevelRepo.findById(courseRequest.getCourseLevelId())
                .orElseThrow(() -> new EntityNotFoundException("not found Course Level")));
        course.setCourseLanguage(courseLanguageRepo.findById(courseRequest.getCourseLanguageId())
                .orElseThrow(() -> new EntityNotFoundException("not found Course Language")));
        course.setUser(userRepo.findById(courseRequest.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("not found User")));
        Course courseCreated = courseRepo.save(course);
        CourseResponse courseResponse = courseMapper.convertEnToRes(courseCreated);
        courseResponse.setTotalUser(enrollmentRepo.countUserByCourseId(courseResponse.getCourseId()));
        courseResponse.setAvgReview(reviewCourseRepo.avgReviewByCourseId(courseResponse.getCourseId()));
        System.out.println("TOTAL USER : ");
        System.out.println(enrollmentRepo.countUserByCourseId(courseResponse.getCourseId()));
        return courseResponse ;
    }

    @Override
    public CourseResponse updateCourse(Integer courseId, CourseRequest courseRequest) {
        return courseRepo.findById(courseId).map(courseExists -> {
            Course course = courseMapper.convertReqToEn(courseRequest);
            course.setCourseId(courseExists.getCourseId());
            course.setCourseCategory(courseCategoryRepo.findById(courseRequest.getCourseCategoryId())
                    .orElseThrow(() -> new EntityNotFoundException("not found Course Category")));
            course.setCourseLevel(courseLevelRepo.findById(courseRequest.getCourseLevelId())
                    .orElseThrow(() -> new EntityNotFoundException("not found Course Level")));
            course.setCourseLanguage(courseLanguageRepo.findById(courseRequest.getCourseLanguageId())
                    .orElseThrow(() -> new EntityNotFoundException("not found Course Language")));
            course.setUser(userRepo.findById(courseRequest.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("not found User")));
            Course courseUpdated = courseRepo.save(course);
            return courseMapper.convertEnToRes(courseUpdated);
        }).orElseThrow(() -> new EntityNotFoundException("not found Course"));
    }
}

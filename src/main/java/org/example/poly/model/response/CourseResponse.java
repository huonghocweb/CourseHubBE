package org.example.poly.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {
    private Integer courseId;
    private String courseTitle;
    private Double coursePrice;
    private String imageUrl;
    private String description;
    private Integer duration_minutes;
    private Integer totalUser;
    private Double avgReview;
    private CourseLevelResponse courseLevel;
    private CourseLanguageResponse courseLanguage;
    private CourseCategoryResponse courseCategory;
    private UserResponse user;
    private List<ReviewCourseResponse> reviewCourses;
    // private List<EnrollmentResponse> enrollments;
}

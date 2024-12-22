package org.example.poly.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private Integer courseId;
    private String courseTitle;
    private Double coursePrice;
    private String imageUrl;
    private String description;
    private Integer duration_minutes;
    private Integer courseLevelId;
    private Integer courseLanguageId;
    private Integer  courseCategoryId;
    private Integer userId;
}

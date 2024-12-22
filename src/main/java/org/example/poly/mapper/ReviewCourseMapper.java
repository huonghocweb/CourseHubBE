package org.example.poly.mapper;

import org.example.poly.model.entity.ReviewCourse;
import org.example.poly.model.response.ReviewCourseResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel="spring")
public interface ReviewCourseMapper {

    ReviewCourseResponse convertEnToRes(ReviewCourse reviewCourse);
    
}

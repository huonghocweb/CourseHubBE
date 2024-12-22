package org.example.poly.mapper;

import org.example.poly.model.entity.Course;
import org.example.poly.model.request.CourseRequest;
import org.example.poly.model.response.CourseResponse;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring" )
public interface CourseMapper {
    CourseResponse convertEnToRes(Course course);



    Course convertReqToEn(CourseRequest courseRequest);
}

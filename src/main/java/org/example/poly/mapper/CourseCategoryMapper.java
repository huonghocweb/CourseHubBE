package org.example.poly.mapper;

import org.example.poly.model.entity.CourseCategory;
import org.example.poly.model.response.CourseCategoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseCategoryMapper {
    CourseCategoryResponse convertEnToRes(CourseCategory courseCategory);
}

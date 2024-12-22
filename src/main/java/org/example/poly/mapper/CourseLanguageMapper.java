package org.example.poly.mapper;

import org.example.poly.model.entity.CourseLanguage;
import org.example.poly.model.response.CourseLanguageResponse;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface CourseLanguageMapper {
    CourseLanguageResponse convertEnToRes(CourseLanguage courseLanguage);
}

package org.example.poly.mapper;

import org.example.poly.model.entity.CourseLevel;
import org.example.poly.model.response.CourseLevelResponse;
import org.mapstruct.Mapper;




@Mapper(componentModel = "spring")
public interface CourseLevelMapper {
   CourseLevelResponse convertEnToRes(CourseLevel courseLevel);
}

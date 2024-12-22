package org.example.poly.mapper;

import org.example.poly.model.entity.LessonVideo;
import org.example.poly.model.response.LessonVideoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface  LessonVideoMapper {
    LessonVideoResponse convertEnToRes(LessonVideo lessonVideo);
    
}

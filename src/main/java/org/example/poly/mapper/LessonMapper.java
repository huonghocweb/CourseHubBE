package org.example.poly.mapper;

import org.example.poly.model.entity.Lesson;
import org.example.poly.model.request.LessonRequest;
import org.example.poly.model.response.LessonResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface LessonMapper {
    LessonResponse convertEnToRes(Lesson lesson);
    Lesson convertReqToEn(LessonRequest lessonRequest);
}

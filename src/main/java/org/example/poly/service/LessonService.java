package org.example.poly.service;

import java.util.List;

import org.example.poly.model.response.LessonResponse;
import org.springframework.stereotype.Service;

@Service
public interface LessonService {
    List<LessonResponse> getLessonByCourseId(Integer courseId);
    LessonResponse getLessonById(Integer lessonId);
    // LessonResponse createLesson(LessonRequest lessonRequest);
    // LessonResponse updateLesson(Integer lessonId, LessonRequest lessonRequest);
}

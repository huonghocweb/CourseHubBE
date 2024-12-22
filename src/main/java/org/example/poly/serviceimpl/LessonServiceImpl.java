package org.example.poly.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.example.poly.mapper.LessonMapper;
import org.example.poly.model.entity.Lesson;
import org.example.poly.model.response.LessonResponse;
import org.example.poly.repo.LessonRepo;
import org.example.poly.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LessonServiceImpl implements  LessonService {

    @Autowired
    private LessonRepo lessonRepo;
    @Autowired 
    private LessonMapper lessonMapper;

    @Override
    public List<LessonResponse> getLessonByCourseId(Integer courseId) {
        List<Lesson> lessons = lessonRepo.getLessonsByCourseId(courseId);
        return lessons.stream()
        .map(lessonMapper :: convertEnToRes)
        .collect(Collectors.toList());
    }

    @Override
    public LessonResponse getLessonById(Integer lessonId) {
        Lesson lesson = lessonRepo.findById(lessonId)
        .orElseThrow(() -> new EntityNotFoundException("not found Lesson"));
        return lessonMapper.convertEnToRes(lesson);
    }
    
}

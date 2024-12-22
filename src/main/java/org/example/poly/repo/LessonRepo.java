package org.example.poly.repo;

import java.util.List;

import org.example.poly.model.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LessonRepo extends  JpaRepository<Lesson,  Integer> {
    @Query("SELECT le FROM Lesson le JOIN le.course c WHERE c.courseId " 
    + " = :courseId")
     List<Lesson> getLessonsByCourseId(@Param("courseId") Integer courseId);
    
}

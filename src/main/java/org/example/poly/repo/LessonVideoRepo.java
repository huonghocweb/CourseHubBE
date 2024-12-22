package org.example.poly.repo;

import org.example.poly.model.entity.LessonVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonVideoRepo extends  JpaRepository<LessonVideo, Integer> {
    
}

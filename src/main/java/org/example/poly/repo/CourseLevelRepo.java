package org.example.poly.repo;

import org.example.poly.model.entity.CourseCategory;
import org.example.poly.model.entity.CourseLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseLevelRepo extends JpaRepository<CourseLevel,Integer > {
}

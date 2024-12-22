package org.example.poly.repo;

import org.example.poly.model.entity.Course;
import org.example.poly.model.entity.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer > {
}

package org.example.poly.repo;

import org.example.poly.model.entity.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseCategoryRepo extends JpaRepository<CourseCategory ,Integer > {
}

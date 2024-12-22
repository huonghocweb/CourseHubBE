package org.example.poly.repo;

import org.example.poly.model.entity.CourseCategory;
import org.example.poly.model.entity.CourseLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseLanguageRepo extends JpaRepository<CourseLanguage,Integer > {
}

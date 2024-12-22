package org.example.poly.repo;

import org.example.poly.model.entity.ReviewCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewCourseRepo extends  JpaRepository<ReviewCourse, Integer> {
    @Query("SELECT AVG(r.rating) FROM ReviewCourse r JOIN r.course c WHERE c.courseId = :courseId")
    Double avgReviewByCourseId(@Param("courseId") Integer courseId);
}

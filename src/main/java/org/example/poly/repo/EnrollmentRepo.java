package org.example.poly.repo;

import org.example.poly.model.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnrollmentRepo extends  JpaRepository<Enrollment, Integer>{
    @Query("SELECT Count(er.user.userId) FROM Enrollment er JOIN er.course c WHERE c.courseId =:courseId ")
    Integer countUserByCourseId(@Param("courseId") Integer courseId);
}

package org.example.poly.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponse {
    private Integer enrollmentId;
    private LocalDateTime enrollmentDateTime;
    private UserResponse user;
    private CourseResponse course;
}

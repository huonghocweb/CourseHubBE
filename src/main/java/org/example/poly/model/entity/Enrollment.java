package org.example.poly.model.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="enrollment_id")
    private Integer enrollmentId;

    @Column(name="enrollment_date_time")
    private LocalDateTime enrollmentDateTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
}

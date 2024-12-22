package org.example.poly.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Integer lessonId;

    @Column(name = "title")
    private String title;

    @Column(name = "order_number")
    private Integer  orderNumber;

    @Column(name="duration_minutes")
    private Integer durationMinutes;

    @JsonIgnore
    @OneToMany(mappedBy = "lesson")
    private List<LessonVideo> lessonVideos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "course_id")
    private Course course;

   @JsonIgnore
   @OneToMany(mappedBy = "lesson")
   private List<Quiz> quizzes;

}
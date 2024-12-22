package org.example.poly.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "course_price")
    private Double coursePrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "duration_minutes")
    private Integer duration_minutes;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="course_level_id")
    private CourseLevel courseLevel;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="course_language_id")
    private CourseLanguage courseLanguage;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="course_category_id")
    private CourseCategory courseCategory;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<CartItem> cartItems;


    @JsonIgnore
    @OneToMany(mappedBy="course")
    private List<ReviewCourse> reviewCourses;

    @JsonIgnore
    @OneToMany(mappedBy="course")
    private List<Lesson> lesssons;
}

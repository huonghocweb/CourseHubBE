package org.example.poly.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "course_language")
public class CourseLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "course_language_id")
    private Integer courseLanguageId;

    @Column(name="course_language_name")
    private String courseLanguageName;
}

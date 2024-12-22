package org.example.poly.model.response;

import java.time.LocalTime;
import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.example.poly.model.entity.Lesson;
import org.example.poly.model.entity.QuizAttempt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponse {
    private Integer quizId;
    private String quizName;
    private LocalTime duration;
    private Double passingGrade;
    private List<QuestionResponse> questions;
}

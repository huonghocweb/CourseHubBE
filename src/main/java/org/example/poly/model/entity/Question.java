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
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="questions")
public class Question {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "question_type")
    private String questionType;

    @Column(name = "points")
    private Integer points;

    @Column(name = "explanation")
    private String explanation;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="quiz_id")
    private Quiz quiz;

    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private List<AnswersOption> answersOptions;

    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private List<Answers> answers;
}

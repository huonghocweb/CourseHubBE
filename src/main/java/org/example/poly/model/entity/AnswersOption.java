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
@Table(name = "answers_options")
public class AnswersOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answers_option_id")
    private Integer answersOptionId;

    @Column(name = "answers_option_label")
    private String answersOptionLabel;

    @Column(name = "answers_option_text")
    private String answersOptionText;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;

    @JsonIgnore
    @OneToMany(mappedBy = "answersOption")
    private List<Answers> answers;
}
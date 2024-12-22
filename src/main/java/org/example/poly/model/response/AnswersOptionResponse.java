package org.example.poly.model.response;

import java.util.List;

import org.example.poly.model.entity.Answers;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswersOptionResponse {
    private Integer answersOptionId;
    private String answersOptionLabel;
    private String answersOptionText;
    private Boolean isCorrect;
    private List<AnswersResponse> answers;
}

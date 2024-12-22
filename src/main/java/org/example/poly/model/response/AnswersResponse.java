package org.example.poly.model.response;

import java.time.LocalDateTime;

import org.example.poly.model.entity.AnswersOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswersResponse {
    private Integer answersId;
    private LocalDateTime createAt;
    private Boolean isCorrect;
    private UserResponse user;
}

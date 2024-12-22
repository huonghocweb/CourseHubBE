package org.example.poly.model.response;

import java.util.List;

import org.example.poly.model.entity.AnswersOption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private Integer questionId;
    private String questionText;
    private String questionType;
    private Integer points;
    private String explanation;
    private List<AnswersOptionResponse> answersOptions;
}

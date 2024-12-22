package org.example.poly.model.response;

import java.util.List;

import org.example.poly.model.entity.Quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse {
    private Integer lessonId;
    private String title;
    private Integer  orderNumber;
    private Integer durationMinutes;
    private List<LessonVideoResponse> lessonVideos;
    private List<QuizResponse> quizzes;
}

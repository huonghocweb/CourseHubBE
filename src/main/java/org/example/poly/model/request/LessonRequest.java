package org.example.poly.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonRequest {
    private String title;
    private Integer  orderNumber;
    private Integer durationMinutes;
    private List<Integer> lessonVideoIds;
//    private List<Quiz> quizzes;
}

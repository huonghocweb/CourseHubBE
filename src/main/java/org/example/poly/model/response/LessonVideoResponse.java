package org.example.poly.model.response;

import org.example.poly.model.entity.Lesson;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonVideoResponse {
    private Integer videoId;
    private String videoTitle;
    private String videoUrl;
    private Integer durationMinutes;
    private Integer orderNumber;
}

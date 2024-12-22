package org.example.poly.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCourseResponse {
    private Integer reviewId;
    private Double rating;
    private String reviewText;
    private String imageUrl;
    private UserResponse user;
}

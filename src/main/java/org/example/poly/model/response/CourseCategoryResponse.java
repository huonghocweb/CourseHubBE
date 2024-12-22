package org.example.poly.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseCategoryResponse {
    private Integer courseCategoryId;
    private String courseCategoryName;
}

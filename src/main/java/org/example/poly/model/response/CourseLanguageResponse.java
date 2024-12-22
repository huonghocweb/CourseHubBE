package org.example.poly.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseLanguageResponse {
    private Integer courseLanguageId;
    private String courseLanguageName;
}

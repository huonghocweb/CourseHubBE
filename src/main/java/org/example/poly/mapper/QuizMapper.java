package org.example.poly.mapper;

import org.example.poly.model.entity.Quiz;
import org.example.poly.model.response.QuizResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface QuizMapper {
    QuizResponse convertEnToRes(Quiz quiz);
    
}

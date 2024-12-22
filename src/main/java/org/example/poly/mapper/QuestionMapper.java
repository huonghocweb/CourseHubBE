package org.example.poly.mapper;

import org.example.poly.model.entity.Question;
import org.example.poly.model.response.QuestionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface  QuestionMapper {
    QuestionResponse convertEnToRes(Question question);
}

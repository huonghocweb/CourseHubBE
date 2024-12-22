package org.example.poly.mapper;

import org.example.poly.model.entity.AnswersOption;
import org.example.poly.model.response.AnswersOptionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface AnswersOptionMapper {
    AnswersOptionResponse convertEnToRes(AnswersOption answersOption);
}

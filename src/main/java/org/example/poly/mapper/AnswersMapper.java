package org.example.poly.mapper;

import org.example.poly.model.entity.Answers;
import org.example.poly.model.response.AnswersResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswersMapper {
    AnswersResponse convertEnToRes(Answers answers);

}

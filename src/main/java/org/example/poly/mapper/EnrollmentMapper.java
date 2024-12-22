package org.example.poly.mapper;

import org.example.poly.model.entity.Enrollment;
import org.example.poly.model.response.EnrollmentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses={UserMapper.class})
public interface EnrollmentMapper {
    EnrollmentResponse convertEnToRes(Enrollment enrollment);
}

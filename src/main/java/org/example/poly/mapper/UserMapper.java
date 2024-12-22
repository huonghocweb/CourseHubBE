package org.example.poly.mapper;

import org.example.poly.model.entity.User;
import org.example.poly.model.request.UserRequest;
import org.example.poly.model.response.UserResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring" , uses = {RoleMapper.class})
public interface UserMapper {
    UserResponse convertEnToRes(User user);
    User convertReqToEn(UserRequest userRequest);
}

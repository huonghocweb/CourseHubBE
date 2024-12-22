package org.example.poly.mapper;

import org.example.poly.model.entity.Role;
import org.example.poly.model.response.RoleResponse;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponse convertEnToRes(Role role);
}

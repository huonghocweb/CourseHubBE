package org.example.poly.mapper;

import org.example.poly.model.entity.CartItem;
import org.example.poly.model.response.CartResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring" , uses =  {CourseMapper.class})
public interface CartItemMapper {
    CartResponse convertEnToRes(CartItem cartItem);
}

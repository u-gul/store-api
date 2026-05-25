package com.sigma.store.mappers;

import com.sigma.store.dtos.CartDto;
import com.sigma.store.dtos.CartItemDto;
import com.sigma.store.entities.Cart;
import com.sigma.store.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toDto(Cart cart);

    @Mapping(target = "totalPrice", expression = "java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);
}

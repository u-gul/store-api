package com.sigma.store.mappers;

import com.sigma.store.dtos.CartDto;
import com.sigma.store.dtos.CartItemDto;
import com.sigma.store.entities.Cart;
import com.sigma.store.entities.CartItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toDto(Cart cart);

    CartItemDto toDto(CartItem cartItem);
}

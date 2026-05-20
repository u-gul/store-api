package com.sigma.store.mappers;

import com.sigma.store.dtos.CartDto;
import com.sigma.store.entities.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toDto(Cart cart);
}

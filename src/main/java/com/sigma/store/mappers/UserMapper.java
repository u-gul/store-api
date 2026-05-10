package com.sigma.store.mappers;

import org.mapstruct.Mapper;

import com.sigma.store.dtos.UserDto;
import com.sigma.store.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}

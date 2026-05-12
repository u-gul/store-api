package com.sigma.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.sigma.store.dtos.RegisterUserRequest;
import com.sigma.store.dtos.UpdateUserRequest;
import com.sigma.store.dtos.UserDto;
import com.sigma.store.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(RegisterUserRequest registerUserRequest);

    void update(UpdateUserRequest updateUserRequest, @MappingTarget User user);
}

package com.sigma.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sigma.store.dtos.ProductDto;
import com.sigma.store.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
}

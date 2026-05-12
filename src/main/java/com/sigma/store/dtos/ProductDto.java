package com.sigma.store.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Byte categoryId;
}

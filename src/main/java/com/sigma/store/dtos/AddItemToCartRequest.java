package com.sigma.store.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AddItemToCartRequest {
    @NotNull
    private Long productId;
}

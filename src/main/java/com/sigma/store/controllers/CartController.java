package com.sigma.store.controllers;

import com.sigma.store.dtos.AddItemToCartRequest;
import com.sigma.store.dtos.CartDto;
import com.sigma.store.dtos.CartItemDto;
import com.sigma.store.entities.Cart;
import com.sigma.store.entities.CartItem;
import com.sigma.store.mappers.CartMapper;
import com.sigma.store.repositories.CartRepository;
import com.sigma.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<CartDto> createCart(
            UriComponentsBuilder uriBuilder
    ) {
        Cart cart = new Cart();
        cartRepository.save(cart);

        CartDto cartDto = cartMapper.toDto(cart);

        URI uri = uriBuilder.path("/carts/{id}").
                buildAndExpand(cartDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(cartDto);
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItemDto> addToCart(
            @PathVariable UUID cartId,
            @RequestBody AddItemToCartRequest request
    ) {
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }

        var product = productRepository.findById(request.getProductId()).orElse(null);
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }

        var cartItem = cart.getCartItems()
                .stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);

        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cartItem.setCart(cart);
            cart.getCartItems().add(cartItem);
        }

        cartRepository.save(cart);

        return ResponseEntity.ok(null);
    }
}

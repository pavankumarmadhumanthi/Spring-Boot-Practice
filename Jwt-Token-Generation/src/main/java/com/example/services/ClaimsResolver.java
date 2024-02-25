package com.example.services;

import io.jsonwebtoken.Claims;
@FunctionalInterface
public interface ClaimsResolver<T> {
    T apply(Claims claims);
}


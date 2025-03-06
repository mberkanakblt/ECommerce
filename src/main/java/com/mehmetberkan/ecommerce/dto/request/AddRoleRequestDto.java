package com.mehmetberkan.ecommerce.dto.request;

public record AddRoleRequestDto(
        String roleName,
        Long userId
) {
}

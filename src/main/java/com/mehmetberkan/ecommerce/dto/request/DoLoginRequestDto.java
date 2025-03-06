package com.mehmetberkan.ecommerce.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DoLoginRequestDto(
        @NotNull
                @NotEmpty
                @Size(min = 6, max = 20)
        String email,
        @NotNull
                @NotEmpty
                @Size(min = 6,max = 64)
        String password
) {
}

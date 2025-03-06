package com.mehmetberkan.ecommerce.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DoRegisterRequestDto(
        @NotNull
        @NotEmpty
        @Size(min = 2, max = 50)
        String ad,
        String adres,
        @NotNull
        @NotEmpty
        String email,
        @NotNull @NotEmpty
        String telefon,
        @NotNull @NotEmpty
        String password,
        String repassword,
        String avatar
) {
}

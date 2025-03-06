package com.mehmetberkan.ecommerce.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RemoveAllSepetRequestDto(
        @NotNull
        @Min(1)
        Long kullaniciId
) {
}

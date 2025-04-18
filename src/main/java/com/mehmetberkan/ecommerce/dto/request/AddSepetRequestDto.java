package com.mehmetberkan.ecommerce.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AddSepetRequestDto(

        @NotNull
        String token,
        @NotNull
        @Min(0)
        Long urunId

) {
}

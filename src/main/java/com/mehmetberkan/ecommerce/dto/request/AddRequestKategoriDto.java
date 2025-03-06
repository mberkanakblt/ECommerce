package com.mehmetberkan.ecommerce.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddRequestKategoriDto(
        @NotNull
        Long parentId,
        @NotNull
        @Size(min = 2, max = 30)
        String ad
) {
}

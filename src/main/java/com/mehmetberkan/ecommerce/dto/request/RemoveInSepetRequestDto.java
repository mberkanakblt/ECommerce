package com.mehmetberkan.ecommerce.dto.request;

public record RemoveInSepetRequestDto(
        Long kullaniciId,
        Long urunId
) {
}

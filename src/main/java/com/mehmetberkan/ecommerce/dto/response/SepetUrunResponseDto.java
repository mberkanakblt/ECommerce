package com.mehmetberkan.ecommerce.dto.response;

import java.math.BigDecimal;

public record SepetUrunResponseDto(
        Long id,
        Long urunId,
        String urunAd,
        String urunResim,
        Integer adet,
        BigDecimal fiyat,
        BigDecimal toplamFiyat
) {
}

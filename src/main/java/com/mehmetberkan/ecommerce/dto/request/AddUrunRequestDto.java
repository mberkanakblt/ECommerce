package com.mehmetberkan.ecommerce.dto.request;

import com.mehmetberkan.ecommerce.utility.enums.Birim;

import java.math.BigDecimal;

public record AddUrunRequestDto(
        String token,
        String ad,
        Long kategoriId,
        String kategorAdi,
        String resim,
        BigDecimal fiyat,
        int stok,
        Integer kdv,
        Birim birim,
        Integer uyariMiktari

) {
}

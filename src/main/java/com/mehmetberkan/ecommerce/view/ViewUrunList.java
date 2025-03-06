package com.mehmetberkan.ecommerce.view;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ViewUrunList {
    Long id;
    String ad;
    String kategoriAdi;
    String resim;
    BigDecimal fiyat;
    int stok;
}

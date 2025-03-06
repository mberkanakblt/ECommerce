package com.mehmetberkan.ecommerce.dto.request;

import com.mehmetberkan.ecommerce.entity.Urun;
import com.mehmetberkan.ecommerce.utility.enums.SepetDegisim;

public record ArttirAzaltRequestDto(
        Long urunId,
        Long kullaniciId,
        SepetDegisim degisim
) {
}

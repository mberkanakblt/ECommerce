package com.mehmetberkan.ecommerce.mapper;

import com.mehmetberkan.ecommerce.dto.request.AddUrunRequestDto;
import com.mehmetberkan.ecommerce.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UrunMapper {
    /**
     * Bu interface in bir nesnesine ihtiyacımız var bu nedenle bir kalıp olarak şu kodlama yapılır
     */
    UrunMapper INSTANCE = Mappers.getMapper(UrunMapper.class);

    /**
     * Dönüşümünü istediğimiz sınıflar için methodlar oluşturuyoruz.
     */
    Urun mapperDtoDanAldiklarinIleBanaUrunVer(AddUrunRequestDto dto);

}

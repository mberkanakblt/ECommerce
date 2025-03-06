package com.mehmetberkan.ecommerce.mapper;

import com.mehmetberkan.ecommerce.dto.request.AddSepetRequestDto;
import com.mehmetberkan.ecommerce.entity.Sepet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface SepetMapper {

    SepetMapper INSTANCE = Mappers.getMapper(SepetMapper.class);
    Sepet fromSepetRequestDto(AddSepetRequestDto dto);
}

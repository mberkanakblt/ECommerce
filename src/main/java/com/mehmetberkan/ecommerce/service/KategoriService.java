package com.mehmetberkan.ecommerce.service;

import com.mehmetberkan.ecommerce.dto.request.AddRequestKategoriDto;
import com.mehmetberkan.ecommerce.entity.Kategori;
import com.mehmetberkan.ecommerce.exception.ECommerceException;
import com.mehmetberkan.ecommerce.exception.ErrorType;
import com.mehmetberkan.ecommerce.repository.KategoriRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KategoriService {
    private final KategoriRepository repository;

    public Kategori addKategori(AddRequestKategoriDto dto) {
        Boolean isExists = repository.existsByAdAndParentId(dto.ad(),dto.parentId());
        if(isExists) throw new ECommerceException(ErrorType.EXISTED_KATEGORI);
        Kategori kategori = Kategori.builder()
                .ad(dto.ad())
                .parentId(dto.parentId())
                .build();
        repository.save(kategori);
        return kategori;

    }

    public List<Kategori> getMainKategori() {
        return repository.findAllByParentId(0L);
    }


    public List<Kategori> getSubKategori(Long parentId) {
        List<Kategori> result =  repository.findAllByParentId(parentId);
        return result;
    }



}

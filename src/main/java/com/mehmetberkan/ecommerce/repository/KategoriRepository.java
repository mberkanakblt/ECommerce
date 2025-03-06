package com.mehmetberkan.ecommerce.repository;

import com.mehmetberkan.ecommerce.entity.Kategori;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KategoriRepository extends JpaRepository<Kategori, Long> {
    Boolean existsByAdAndParentId(String ad, Long parentId);
    List<Kategori> findAllByParentId(Long parentId);

}

package com.mehmetberkan.ecommerce.repository;

import com.mehmetberkan.ecommerce.entity.Urun;
import com.mehmetberkan.ecommerce.view.ViewUrunList;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UrunRepository extends JpaRepository<Urun, Long> {
    @Query("select new com.mehmetberkan.ecommerce.view.ViewUrunList(u.id,u.ad,u.kategoriAdi,u.resim,u.fiyat,u.stok) from Urun u")
    List<ViewUrunList> getAllUrunList();

    List<Urun> findAllByAdContaining(String urunAdi);

    List<Urun> getUrunById(Long urunId);
}

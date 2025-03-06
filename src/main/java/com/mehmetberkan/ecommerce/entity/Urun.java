package com.mehmetberkan.ecommerce.entity;

import com.mehmetberkan.ecommerce.utility.enums.Birim;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tblurun")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long kategoriId;
    String kategoriAdi;
    String ad;
    String resim;
    BigDecimal fiyat;
    int stok;
    Integer kdv;
    Birim birim;
    Integer uyariMiktari;
}

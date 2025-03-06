package com.mehmetberkan.ecommerce.entity;

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
@Table(name = "tblsepeturunleri")
public class SepetUrunleri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long sepetId;
    Long urunId;
    Integer adet;
    BigDecimal fiyat;
    BigDecimal toplamFiyat;
}

package com.mehmetberkan.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tblkullanici")
public class Kullanici {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, length = 80)
    String ad;
    String adres;
    @Column(nullable = false,unique = true)
    String email;
    @Column(nullable = false,unique = true)
    String telefon;
    @Column(nullable = false,length = 50)
    String password;
    String avatar;
}

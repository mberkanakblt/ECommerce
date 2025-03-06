package com.mehmetberkan.ecommerce.repository;

import com.mehmetberkan.ecommerce.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {
    Optional<Kullanici> findOptionalByEmailAndPassword(String email, String password);
}

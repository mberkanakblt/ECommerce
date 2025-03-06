package com.mehmetberkan.ecommerce.repository;


import com.mehmetberkan.ecommerce.entity.Sepet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SepetRepository extends JpaRepository<Sepet, Long> {

    Optional<Sepet> findOptionalByUserId(Long userId);
}

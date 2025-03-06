package com.mehmetberkan.ecommerce.repository;

import com.mehmetberkan.ecommerce.dto.request.RemoveAllSepetRequestDto;
import com.mehmetberkan.ecommerce.dto.request.RemoveInSepetRequestDto;
import com.mehmetberkan.ecommerce.entity.Sepet;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SepetRepository extends JpaRepository<Sepet, Long> {

    Optional<Sepet> findOptionalByUserId(Long userId);
}

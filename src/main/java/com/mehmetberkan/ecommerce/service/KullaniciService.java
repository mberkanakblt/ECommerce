package com.mehmetberkan.ecommerce.service;

import com.mehmetberkan.ecommerce.dto.request.DoLoginRequestDto;
import com.mehmetberkan.ecommerce.dto.request.DoRegisterRequestDto;
import com.mehmetberkan.ecommerce.entity.Kullanici;
import com.mehmetberkan.ecommerce.repository.KullaniciRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KullaniciService {
    private final KullaniciRepository kullaniciRepository;

    public void doRegister(@Valid DoRegisterRequestDto dto) {
        kullaniciRepository.save(Kullanici.builder()
                        .ad(dto.ad())
                        .email(dto.email())
                        .adres(dto.adres())
                        .avatar(dto.avatar())
                        .telefon(dto.telefon())
                        .password(dto.password())
                .build());
    }

    public Optional<Kullanici> findByEmailPassword(DoLoginRequestDto dto) {
        return kullaniciRepository.findOptionalByEmailAndPassword(dto.email(), dto.password());
    }

    public Optional<Kullanici> findByUserId(Long userId) {
        return kullaniciRepository.findById(userId);
    }
}

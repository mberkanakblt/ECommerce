package com.mehmetberkan.ecommerce.controller;

import com.mehmetberkan.ecommerce.config.JwtManager;
import com.mehmetberkan.ecommerce.dto.request.AddRoleRequestDto;
import com.mehmetberkan.ecommerce.dto.request.DoLoginRequestDto;
import com.mehmetberkan.ecommerce.dto.request.DoRegisterRequestDto;
import com.mehmetberkan.ecommerce.dto.response.BaseResponse;
import com.mehmetberkan.ecommerce.entity.Kullanici;
import com.mehmetberkan.ecommerce.exception.ECommerceException;
import com.mehmetberkan.ecommerce.exception.ErrorType;
import com.mehmetberkan.ecommerce.service.KullaniciService;
import com.mehmetberkan.ecommerce.service.UserRoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.mehmetberkan.ecommerce.config.RestApis.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(KULLANICI)
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class KullaniciController {
    private final KullaniciService kullaniciService;
    private final JwtManager jwtManager;
    private final UserRoleService userRoleService;

    @PostMapping(DOREGİSTER)
    public ResponseEntity<BaseResponse<Boolean>> doRegister(@RequestBody @Valid DoRegisterRequestDto dto){
        if(!dto.password().equals(dto.repassword()))
            throw new ECommerceException(ErrorType.EMAIL_SIFRE_HATASI);
        kullaniciService.doRegister(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .message("Basariyla kaydedildi")
                        .code(200)
                        .data(true)
                .build());
    }

    @PostMapping(LOGIN)
    public ResponseEntity<BaseResponse<String>> doLogin(@RequestBody DoLoginRequestDto dto){
        Optional<Kullanici> optionalKullanici = kullaniciService.findByEmailPassword(dto);
        if(optionalKullanici.isEmpty())
            throw new ECommerceException(ErrorType.SIFREHATASI);
        return ResponseEntity.ok(BaseResponse.<String>builder()
                        .message("Basariyla giris yapildi")
                        .code(200)
                        .data(jwtManager.createToken(optionalKullanici.get().getId()))
                .build());
    }

    @PostMapping("/add-role")
    public ResponseEntity<BaseResponse<Boolean>> addRole(@RequestBody AddRoleRequestDto dto){
        userRoleService.addRole(dto.roleName(), dto.userId());
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Ok")
                        .data(true)
                .build());
    }

    @GetMapping("/get-user-name/{token}")
    public ResponseEntity<BaseResponse<String>> getUserName(@PathVariable String token){
        Optional<Long> optionalUserId = jwtManager.validateToken(token);
        if(optionalUserId.isEmpty())    throw new ECommerceException(ErrorType.INVALID_TOKEN);
        Optional<Kullanici> optionalKullanici = kullaniciService.findByUserId(optionalUserId.get());
        if(optionalKullanici.isEmpty()) throw new ECommerceException(ErrorType.USER_NOT_FOUND);
        return ResponseEntity.ok(BaseResponse.<String>builder()
                        .code(200)
                        .message("Kullanıcıc adı basariyla getirildi")
                        .data(optionalKullanici.get().getAd())
                .build());
    }






}

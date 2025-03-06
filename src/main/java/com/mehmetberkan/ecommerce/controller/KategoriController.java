package com.mehmetberkan.ecommerce.controller;

import com.mehmetberkan.ecommerce.dto.request.AddRequestKategoriDto;
import com.mehmetberkan.ecommerce.dto.response.BaseResponse;
import com.mehmetberkan.ecommerce.entity.Kategori;
import com.mehmetberkan.ecommerce.service.KategoriService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mehmetberkan.ecommerce.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(KATEGORI)
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class KategoriController {
    private final KategoriService kategoriService;

    @PostMapping(ADD_KATEGORI)
    public ResponseEntity<BaseResponse<Kategori>> addKategori(@RequestBody @Valid AddRequestKategoriDto dto) {
        kategoriService.addKategori(dto);
        return ResponseEntity.ok(BaseResponse.<Kategori>builder()
                        .message("Basariyla eklendi")
                        .code(200)
                        .data(kategoriService.addKategori(dto))
                .build());
    }

    @GetMapping(GET_MAIN_KATEGORİ)
    public ResponseEntity<BaseResponse<List<Kategori>>> getMainKategori(){
        return ResponseEntity.ok(BaseResponse.<List<Kategori>>builder()
                        .message("Main kategori listelendi")
                        .code(200)
                        .data(kategoriService.getMainKategori())
                .build());
    }
    @GetMapping(GET_SUB_KATEGORI)
    public ResponseEntity<BaseResponse<List<Kategori>>> getAllKategori(Long parentId){
        return ResponseEntity.ok(BaseResponse.<List<Kategori>>builder()
                        .message("Tum kategori listelendi")
                        .code(200)
                        .data(kategoriService.getSubKategori(parentId))
                .build());
    }




}

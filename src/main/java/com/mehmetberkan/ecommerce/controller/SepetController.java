package com.mehmetberkan.ecommerce.controller;
import com.mehmetberkan.ecommerce.dto.request.AddSepetRequestDto;
import com.mehmetberkan.ecommerce.dto.request.ArttirAzaltRequestDto;
import com.mehmetberkan.ecommerce.dto.request.RemoveAllSepetRequestDto;
import com.mehmetberkan.ecommerce.dto.request.RemoveInSepetRequestDto;
import com.mehmetberkan.ecommerce.dto.response.BaseResponse;
import com.mehmetberkan.ecommerce.dto.response.SepetUrunResponseDto;
import com.mehmetberkan.ecommerce.service.SepetService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.ServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mehmetberkan.ecommerce.config.RestApis.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(SEPET)
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class SepetController {
    private final SepetService sepetService;

    @PostMapping(ADD_SEPET)
    public ResponseEntity<BaseResponse<Boolean>> addSepet(@RequestBody AddSepetRequestDto dto){
        sepetService.addSepet(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Sepet olusturuldu")
                        .data(true)
                .build());
    }
    @DeleteMapping(REMOVE_IN_SEPET)
    public ResponseEntity<BaseResponse<Boolean>> removeSepet(@RequestBody @Valid RemoveInSepetRequestDto dto, ServletRequest servletRequest){
        sepetService.removeInSepet(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Urun sepetten atildi")
                        .data(true)
                .build());
    }
    @DeleteMapping(CLEAR_SEPET)
    public ResponseEntity<BaseResponse<Boolean>> clearSepet(@RequestBody @Valid RemoveAllSepetRequestDto dto){
        sepetService.removeAllSepet(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Sepet temizlendi.")
                        .data(true)
                .build());
    }
    @PostMapping(UP_DOWN_SEPET)
    public ResponseEntity<BaseResponse<Boolean>> arttirAzalt(@RequestBody ArttirAzaltRequestDto dto){
        sepetService.arttirAzaltSepet(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Sepet temizlendi")
                        .data(true)
                .build());
    }
    @GetMapping(GET_ALL_SEPET+"/{userId}")
    public ResponseEntity<BaseResponse<List<SepetUrunResponseDto>>> getAllSepet(@PathVariable Long userId){

        return ResponseEntity.ok(BaseResponse.<List<SepetUrunResponseDto>>builder()
                        .code(200)
                        .message("Sepet Getirildi.")
                        .data(sepetService.getAllSepet(userId))

                .build());
    }
}

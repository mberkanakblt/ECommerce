package com.mehmetberkan.ecommerce.controller;
import com.mehmetberkan.ecommerce.config.JwtManager;
import com.mehmetberkan.ecommerce.dto.request.AddUrunRequestDto;
import com.mehmetberkan.ecommerce.dto.response.BaseResponse;
import com.mehmetberkan.ecommerce.entity.Urun;
import com.mehmetberkan.ecommerce.exception.ECommerceException;
import com.mehmetberkan.ecommerce.exception.ErrorType;
import com.mehmetberkan.ecommerce.repository.UrunRepository;
import com.mehmetberkan.ecommerce.service.UrunService;
import com.mehmetberkan.ecommerce.view.ViewUrunList;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.mehmetberkan.ecommerce.config.RestApis.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(URUN)
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class UrunController {

    private final UrunService urunService;
    private final JwtManager jwtManager;

    @PostMapping(ADD_URUN)
    public ResponseEntity<BaseResponse<Boolean>> addUrun(@RequestBody AddUrunRequestDto dto){
        Optional<Long> userID= jwtManager.validateToken(dto.token());
        if(userID.isEmpty())
            throw new ECommerceException(ErrorType.INVALID_TOKEN);
        urunService.addUrun(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Urun basariyla kaydedildi.")
                        .data(true)
                .build());
    }

    @GetMapping(GET_ALL_URUN)
    public ResponseEntity<BaseResponse<List<ViewUrunList>>> getUrunList(){
        return ResponseEntity.ok(BaseResponse.<List<ViewUrunList>>builder()
                        .code(200)
                        .message("Urun listesi basariyla getirildi.")
                        .data(urunService.getViewUrunList())
                .build());
    }

    @GetMapping(GET_URUN_BY_NAME+"/{urunAdi}")
    public ResponseEntity<BaseResponse<List<Urun>>> findByAd(@PathVariable String urunAdi){
        return ResponseEntity.ok(BaseResponse.<List<Urun>>builder()
                        .code(200)
                        .message("Urun basariyla getirildi.")
                        .data(urunService.findByUrunAd(urunAdi))
                .build());
    }
    @DeleteMapping(DELETE_URUN+"/{urunId}")
    public ResponseEntity<BaseResponse<Boolean>> deleteUrunById(@PathVariable Long urunId){
        urunService.deleteUrun(urunId);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Urun basariyla silindi.")
                        .data(true)
                .build());

    }
    @PutMapping(REDUCE_STOCK+"/{urunId}")
    public ResponseEntity<BaseResponse<Urun>> reduceStock(@RequestBody Long urunId, @RequestBody Integer miktar){
        return ResponseEntity.ok(BaseResponse.<Urun>builder()
                        .code(200)
                        .message("Stok basariyla azaltildi.")
                        .data( urunService.stokAzaltma(urunId, miktar))
                .build());
    }

    @PutMapping(INCREASE_STOCK+"/{urunId}")
    public ResponseEntity<BaseResponse<Urun>> increaseStock(@RequestBody Long urunId,@RequestBody int miktar){
        return ResponseEntity.ok(BaseResponse.<Urun>builder()
                .code(200)
                .message("Stok basariyla arttirildi.")
                .data(urunService.stokArtirma(urunId,miktar))
                .build());
    }

}

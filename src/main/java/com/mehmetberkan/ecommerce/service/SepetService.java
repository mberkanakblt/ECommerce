package com.mehmetberkan.ecommerce.service;

import com.mehmetberkan.ecommerce.dto.request.AddSepetRequestDto;
import com.mehmetberkan.ecommerce.dto.request.ArttirAzaltRequestDto;
import com.mehmetberkan.ecommerce.dto.request.RemoveAllSepetRequestDto;
import com.mehmetberkan.ecommerce.dto.request.RemoveInSepetRequestDto;
import com.mehmetberkan.ecommerce.dto.response.SepetUrunResponseDto;
import com.mehmetberkan.ecommerce.entity.Sepet;
import com.mehmetberkan.ecommerce.entity.SepetUrunleri;
import com.mehmetberkan.ecommerce.entity.Urun;
import com.mehmetberkan.ecommerce.exception.ECommerceException;
import com.mehmetberkan.ecommerce.exception.ErrorType;
import com.mehmetberkan.ecommerce.mapper.SepetMapper;
import com.mehmetberkan.ecommerce.repository.SepetRepository;
import com.mehmetberkan.ecommerce.repository.SepetUrunleriRepository;
import com.mehmetberkan.ecommerce.repository.UrunRepository;
import com.mehmetberkan.ecommerce.utility.enums.SepetDegisim;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SepetService {
    private final SepetRepository sepetRepository;
    private final UrunRepository urunRepository;
    private final SepetUrunleriRepository sepetUrunleriRepository;
    private final UrunService urunService;
    private final ISatisService satisService;

    @Bean
    private ISatisService getSatisService() {
        return new SatisService();
    }

    public void addSepet(AddSepetRequestDto dto) {

        Sepet sepet;
        Optional<Sepet> sepetOptional = sepetRepository.findOptionalByUserId(dto.kullaniciId());
        if(sepetOptional.isEmpty()){
            sepet = SepetMapper.INSTANCE.fromSepetRequestDto(dto);
       sepetRepository.save(sepet);
        }else {
            sepet = sepetOptional.get();
        }
        Optional<Urun> urunOptional = urunService.findOptionalById(dto.urunId());
        if(urunOptional.isEmpty()) throw new ECommerceException(ErrorType.URUN_NOTFOUND);
        Urun urun = urunOptional.get();
        Optional<SepetUrunleri> su = sepetUrunleriRepository.findOptionalBySepetIdAndUrunId(sepet.getId(),dto.urunId());
        SepetUrunleri sepetUrunleri;
        if(su.isEmpty())
            sepetUrunleri = SepetUrunleri.builder()
                    .sepetId(sepet.getId())
                    .urunId(dto.urunId())
                    .adet(1)
                    .fiyat(urun.getFiyat())
                    .toplamFiyat(urun.getFiyat())
                    .build();
        else {
            sepetUrunleri = su.get();
            sepetUrunleri.setAdet(sepetUrunleri.getAdet()+1);
            sepetUrunleri.setToplamFiyat(sepetUrunleri.getFiyat().multiply(BigDecimal.valueOf(sepetUrunleri.getAdet())));
        }

        sepetUrunleriRepository.save(sepetUrunleri);

    }

    public void removeInSepet(@Valid RemoveInSepetRequestDto dto) {
        Long sepetId= getSepetIdFromUserId(dto.kullaniciId());
        Optional<SepetUrunleri> sepetUrunleri = sepetUrunleriRepository.findOptionalBySepetIdAndUrunId(sepetId,dto.urunId());
        if (sepetUrunleri.isEmpty()) throw new ECommerceException(ErrorType.SEPET_URUN_NOTFOUND);
        sepetUrunleriRepository.delete(sepetUrunleri.get());
    }

    public void removeAllSepet(RemoveAllSepetRequestDto dto) {
        Long sepetId = getSepetIdFromUserId(dto.kullaniciId());
        List<SepetUrunleri> sepetListesi = sepetUrunleriRepository.findAllBySepetId(sepetId);
        sepetUrunleriRepository.deleteAll(sepetListesi);
    }

    public void arttirAzaltSepet(ArttirAzaltRequestDto dto) {
        Long sepetId = getSepetIdFromUserId(dto.kullaniciId());
        Optional<SepetUrunleri> sepetUrunleri = sepetUrunleriRepository.findOptionalBySepetIdAndUrunId(sepetId,dto.urunId());
        if(sepetUrunleri.isEmpty()) throw new ECommerceException(ErrorType.SEPET_URUN_NOTFOUND);
        SepetUrunleri urun = sepetUrunleri.get();
        if(dto.degisim().equals(SepetDegisim.ARTTIR)){ // sayıyı arttır
            urun.setAdet(urun.getAdet()+1);
            sepetUrunleriRepository.save(urun);
        }else { // azaltma işlemi
            // DİKKAT!! ürün adedi 2 ve üzeinde ise arttırma yap, altında ise sil
            if(urun.getAdet()>1){
                urun.setAdet(urun.getAdet()-1);
                sepetUrunleriRepository.save(urun);
            }else {
                sepetUrunleriRepository.delete(urun);
            }
        }
    }
    public List<SepetUrunResponseDto> getAllSepet(Long userId) {
        List<SepetUrunResponseDto> result = new ArrayList<>();
        Long sepetId = getSepetIdFromUserId(userId);
        List<SepetUrunleri> sepetList = sepetUrunleriRepository.findAllBySepetId(sepetId);
        sepetList.forEach(s->{
            Optional<Urun> urun = urunService.findOptionalById(s.getUrunId());
            if(urun.isPresent()){
                SepetUrunResponseDto dto = new SepetUrunResponseDto(
                        s.getId(),
                        s.getUrunId(),
                        urun.get().getAd(),
                        urun.get().getResim(),
                        s.getAdet(),
                        s.getFiyat(),
                        s.getToplamFiyat()
                );
                result.add(dto);
            }
        });
        return result;
    }
    public void sepetOnayla(Long userId){
        /**
         * sepet onayı işlemi
         * sepet i boşaltır.
         * sepet içerisindeki ürünleri satışa aktarır.
         */
        satisService.sepetAkatar(List.of());
    }

    /**
     * Kullanıcı Id si verilerek sepet id bilgisi alınmaktadır.
     * @param userId
     * @return
     */
    private Long getSepetIdFromUserId(Long userId) {
        Optional<Sepet> sepetOptional = sepetRepository.findOptionalByUserId(userId);
        if(sepetOptional.isEmpty()) throw new ECommerceException(ErrorType.SEPET_NOTFOUND);
        Long sepetId = sepetOptional.get().getId();
        return sepetId;
    }
}

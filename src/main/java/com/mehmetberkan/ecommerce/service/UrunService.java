package com.mehmetberkan.ecommerce.service;

import com.mehmetberkan.ecommerce.dto.request.AddUrunRequestDto;
import com.mehmetberkan.ecommerce.entity.Urun;
import com.mehmetberkan.ecommerce.exception.ECommerceException;
import com.mehmetberkan.ecommerce.exception.ErrorType;
import com.mehmetberkan.ecommerce.mapper.UrunMapper;
import com.mehmetberkan.ecommerce.repository.UrunRepository;
import com.mehmetberkan.ecommerce.view.ViewUrunList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrunService {
    private final UrunRepository urunRepository;

    public void addUrun(AddUrunRequestDto dto) {
        Urun urun = UrunMapper.INSTANCE.mapperDtoDanAldiklarinIleBanaUrunVer(dto);
        urunRepository.save(urun);
    }

    public List<ViewUrunList> getViewUrunList() {
         return urunRepository.getAllUrunList();
    }

    public List<Urun> findByUrunAd(String urunAdi) {
        return urunRepository.findAllByAdContaining(urunAdi);

    }
    public Urun stokAzaltma(Long urunId, Integer miktar){
        Optional<Urun> urunOptional = urunRepository.findById(urunId);
        if(urunOptional.isEmpty())throw new ECommerceException(ErrorType.URUN_NOTFOUND);
        Urun urun = urunOptional.get();
        urun.setStok(urun.getStok()-miktar);
        urunRepository.save(urun);
        return urun;
    }


    public void deleteUrun(Long urunId) {
        urunRepository.deleteById(urunId);
    }

    public Urun stokArtirma(Long urunId, int miktar) {
        Optional<Urun> urunOptional = urunRepository.findById(urunId);
        if(urunOptional.isEmpty())throw new ECommerceException(ErrorType.URUN_NOTFOUND);
        Urun urun = urunOptional.get();
        urun.setStok(urun.getStok()+miktar);
        urunRepository.save(urun);
        return urun;
    }


    public Optional<Urun> findOptionalById(Long urunId) {
        return urunRepository.findById(urunId);
    }

    public List<Urun> getUrun(Long urunId) {

        return urunRepository.getUrunById(urunId);
    }
}

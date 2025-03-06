package com.mehmetberkan.ecommerce.service;

import com.mehmetberkan.ecommerce.entity.Urun;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SatisService implements ISatisService{
    @Override
    public boolean sepetAkatar(List<Urun> urunList) {
        return false;
    }
}

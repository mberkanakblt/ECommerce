package com.mehmetberkan.ecommerce.service;

import com.mehmetberkan.ecommerce.entity.Urun;

import java.util.List;

public interface ISatisService {
    boolean sepetAkatar(List<Urun> urunList);
}

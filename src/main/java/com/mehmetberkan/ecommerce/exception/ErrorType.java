package com.mehmetberkan.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorType {


    BADREQUEST(4002, "Girilen parametereler hatalıdır.",BAD_REQUEST),
    SIFREHATASI(4003, "Girişlen şifreler bir biri ile uyuşumamaktadır.",BAD_REQUEST),
    EMAIL_SIFRE_HATASI(4004, "Kullanıcı adı ya da şifre hatalısır", BAD_REQUEST),
    EXISTED_KATEGORI(4005, "Bu kategori zaten kayıtlıdır.", BAD_REQUEST),
    URUN_NOTFOUND(2001, "Id si verilen ürün bulunamadı", INTERNAL_SERVER_ERROR),
    SEPET_NOTFOUND(2002, "KullanıcıId si verilen sepet e ait kayıt bulunamadı", INTERNAL_SERVER_ERROR),
    SEPET_URUN_NOTFOUND(2003, "Id si verilen ürün ilgili sepette bulunamadı", INTERNAL_SERVER_ERROR),
    INVALID_TOKEN(4999, "Geçersiz token bilgisi", FORBIDDEN),
    INTERNAL_SERVER(5000, "Sunucuda beklenmeyen bir hata",INTERNAL_SERVER_ERROR);

    int code;
    String message;
    HttpStatus httpStatus;
}

package com.mehmetberkan.ecommerce.exception;
import lombok.Getter;

@Getter
public class ECommerceException extends RuntimeException {
    private ErrorType errorType;
    public ECommerceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

}

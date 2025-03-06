package com.mehmetberkan.ecommerce.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class ErrorMessage {
    Integer code;
    String message;
    Boolean isSuccess;
    List<String> fields;


}

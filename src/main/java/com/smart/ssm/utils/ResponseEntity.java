package com.smart.ssm.utils;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseEntity<T> {
    private int status;
    private String msg;
    private T  data;

    public ResponseEntity() {
    }

    public static <T> ResponseEntity<T> success(T data){
        return (ResponseEntity<T>) ResponseEntity.builder()
                .data(data)
                .msg(ErrorStatus.SUCCESS.getMessage())
                .status(ErrorStatus.SERVICE_ERROR.getStatus())
                .build();
    }
    public static <T> ResponseEntity<T> success(ErrorStatus errorStatus,T data){
        return (ResponseEntity<T>) ResponseEntity.builder()
                .data(data)
                .msg(errorStatus.getMessage())
                .status(errorStatus.getStatus())
                .build();

    }
    public static <T> ResponseEntity<T> error(ErrorStatus errorStatus,T data){
        return (ResponseEntity<T>) ResponseEntity.builder()
                .data(data)
                .status(errorStatus.getStatus())
                .msg(errorStatus.getMessage()).build();
    }
    public static <T> ResponseEntity<T> error(){
        return (ResponseEntity<T>) ResponseEntity.builder()
                .msg(ErrorStatus.SYS_ERROR.getMessage())
                .status(ErrorStatus.SYS_ERROR.getStatus())
                .build();
    }
}

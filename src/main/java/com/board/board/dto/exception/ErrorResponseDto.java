package com.board.board.dto.exception;

import lombok.Getter;

@Getter
public class ErrorResponseDto{

    private final Error error;

    public ErrorResponseDto(int status, String message){
        this.error = new Error(status,message);
    }
    record Error(
            int status,
            String message
    ){}
}

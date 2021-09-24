package com.schizhande.usermanagerservice.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public final class ApiResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Africa/Harare")
    private final LocalDateTime timestamp;

    private final Integer status;

    private final String error;

    private final String message;

    private ApiResponse(Integer status, String error, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public static ApiResponse with(Integer status, String message, String error) {
        return new ApiResponse(status, error, message);
    }
}

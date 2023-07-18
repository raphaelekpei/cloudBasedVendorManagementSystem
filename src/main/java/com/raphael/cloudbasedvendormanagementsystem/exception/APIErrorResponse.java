package com.raphael.cloudbasedvendormanagementsystem.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class APIErrorResponse {

    private String errorMessage;
    private HttpStatus status;
    private LocalDateTime timestamp;
    private boolean isSuccessful;
    // private String path;

}

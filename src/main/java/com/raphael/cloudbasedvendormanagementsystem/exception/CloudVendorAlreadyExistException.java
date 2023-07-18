package com.raphael.cloudbasedvendormanagementsystem.exception;

import lombok.Getter;

@Getter
public class CloudVendorAlreadyExistException extends RuntimeException {
    public CloudVendorAlreadyExistException(String message) {
        super(message);
    }
}

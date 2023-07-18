package com.raphael.cloudbasedvendormanagementsystem.exception;

import lombok.Getter;

@Getter
public class CloudVendorNotFoundException extends RuntimeException {
    public CloudVendorNotFoundException(String message) {
        super(message);
    }
}

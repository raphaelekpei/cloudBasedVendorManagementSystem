package com.raphael.cloudbasedvendormanagementsystem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class CloudVendorManagementException extends RuntimeException {
    public CloudVendorManagementException(String message) {
        super(message);
    }
}

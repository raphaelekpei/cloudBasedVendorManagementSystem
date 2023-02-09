package com.raphael.cloudbasedvendormanagementsystem.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCloudVendorRequest {
    private String name;
    private String address;
    private String phoneNumber;
}

package com.raphael.cloudbasedvendormanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class CreateCloudVendorRequest {

    private String name;
    private String address;
    private String phoneNumber;
}

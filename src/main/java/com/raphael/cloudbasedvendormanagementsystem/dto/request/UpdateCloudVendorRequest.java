package com.raphael.cloudbasedvendormanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UpdateCloudVendorRequest {
    private String name;
    private String address;
    private String phoneNumber;
}

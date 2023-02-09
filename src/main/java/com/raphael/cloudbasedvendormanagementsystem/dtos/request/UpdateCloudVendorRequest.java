package com.raphael.cloudbasedvendormanagementsystem.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCloudVendorRequest {
    private String name;
    private String address;
    private String phoneNumber;
}

package com.raphael.cloudbasedvendormanagementsystem.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cloud_vendor_info")
@Getter
@Setter
@ToString
public class CloudVendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vendorId;
    private String name;
    private String address;
    private String phoneNumber;

    public CloudVendor(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}

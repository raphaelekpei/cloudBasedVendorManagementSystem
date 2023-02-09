package com.raphael.cloudbasedvendormanagementsystem.service;

import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
import com.raphael.cloudbasedvendormanagementsystem.dtos.request.CreateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dtos.request.UpdateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dtos.response.CreateCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.dtos.response.UpdateCloudVendorResponse;

import java.util.List;

public interface CloudVendorService {
    CreateCloudVendorResponse createCloudVendor(CreateCloudVendorRequest createCloudVendorRequest);

    CloudVendor getCloudVendorById(Long vendorId);

    List<CloudVendor> getAllCloudVendor();

    UpdateCloudVendorResponse updateCloudVendor(Long vendorId, UpdateCloudVendorRequest updateCloudVendorRequest);

    void deleteCloudVendor(Long vendorId);

    void deleteAllCloudVendors();
}

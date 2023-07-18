package com.raphael.cloudbasedvendormanagementsystem.service;

import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
import com.raphael.cloudbasedvendormanagementsystem.dto.request.CreateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dto.request.UpdateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dto.response.CreateCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.dto.response.GetCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.dto.response.UpdateCloudVendorResponse;

import java.util.List;

public interface CloudVendorService {
    CreateCloudVendorResponse createCloudVendor(CreateCloudVendorRequest createCloudVendorRequest);

    GetCloudVendorResponse getCloudVendorById(Long vendorId);

    List<CloudVendor> getAllCloudVendor();

    UpdateCloudVendorResponse updateCloudVendor(Long vendorId, UpdateCloudVendorRequest updateCloudVendorRequest);

    String deleteCloudVendorById(Long vendorId);

    String deleteAllCloudVendors();

}

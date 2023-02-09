package com.raphael.cloudbasedvendormanagementsystem.controller;

import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
import com.raphael.cloudbasedvendormanagementsystem.dtos.request.CreateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dtos.request.UpdateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dtos.response.CreateCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.dtos.response.UpdateCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.service.CloudVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cloud_vendors")
@RequiredArgsConstructor
public class CloudVendorController {

    @Autowired
    private final CloudVendorService cloudVendorService;

    @PostMapping("/create")
    public CreateCloudVendorResponse createCloudVendor(CreateCloudVendorRequest createCloudVendorRequest){
        return cloudVendorService.createCloudVendor(createCloudVendorRequest);

    }

    @GetMapping("/vendor/get")
    public CloudVendor getCloudVendorById(Long vendorId){
        return cloudVendorService.getCloudVendorById(vendorId);
    }

    @GetMapping("/vendor/get-all")
    public List<CloudVendor> getAllCloudVendor(){
        return cloudVendorService.getAllCloudVendor();
    }

    @PutMapping("/update/{vendorId}")
    public UpdateCloudVendorResponse updateCloudVendor(@PathVariable Long vendorId, UpdateCloudVendorRequest updateCloudVendorRequest){
        return cloudVendorService.updateCloudVendor(vendorId, updateCloudVendorRequest);
    }

    @DeleteMapping("/delete/{vendorId}")
    public String deleteCloudVendorById(@PathVariable Long vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "cloud vendor deleted successfully";
    }

    @DeleteMapping("/delete-all")
    public String deleteAllCloudVendors(){
        cloudVendorService.deleteAllCloudVendors();
        return "cloud vendor deleted successfully";
    }



}

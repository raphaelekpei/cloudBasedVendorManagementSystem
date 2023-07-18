package com.raphael.cloudbasedvendormanagementsystem.controller;

import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
import com.raphael.cloudbasedvendormanagementsystem.dto.request.CreateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dto.request.UpdateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dto.response.CreateCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.dto.response.GetCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.dto.response.UpdateCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.service.CloudVendorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cloud-vendors")
@AllArgsConstructor
public class CloudVendorController {
    private final CloudVendorService cloudVendorService;

    @PostMapping("/create")
    public ResponseEntity<CreateCloudVendorResponse> createCloudVendor(@Valid @RequestBody CreateCloudVendorRequest createCloudVendorRequest){
        return ResponseEntity.ok(cloudVendorService.createCloudVendor(createCloudVendorRequest));
    }

    @GetMapping("/{vendorId}")
    public ResponseEntity<GetCloudVendorResponse> getCloudVendorById(@PathVariable Long vendorId){
        return ResponseEntity.ok(cloudVendorService.getCloudVendorById(vendorId));

    }

    @GetMapping("/all")
    public List<CloudVendor> getAllCloudVendor(){
        return cloudVendorService.getAllCloudVendor();
    }

    @PutMapping("/{vendorId}")
    public UpdateCloudVendorResponse updateCloudVendor(@PathVariable Long vendorId, @Valid @RequestBody UpdateCloudVendorRequest updateCloudVendorRequest){
        return cloudVendorService.updateCloudVendor(vendorId, updateCloudVendorRequest);
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendorById(@PathVariable Long vendorId){
        return cloudVendorService.deleteCloudVendorById(vendorId);
    }

    @DeleteMapping("/all")
    public String deleteAllCloudVendors(){
        return cloudVendorService.deleteAllCloudVendors();
    }

}

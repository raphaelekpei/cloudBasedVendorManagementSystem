package com.raphael.cloudbasedvendormanagementsystem.service;

import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
import com.raphael.cloudbasedvendormanagementsystem.data.repository.CloudVendorRepository;
import com.raphael.cloudbasedvendormanagementsystem.dto.request.CreateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dto.request.UpdateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dto.response.CreateCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.dto.response.GetCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.dto.response.UpdateCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.exception.CloudVendorAlreadyExistException;
import com.raphael.cloudbasedvendormanagementsystem.exception.CloudVendorNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CloudVendorServiceImpl implements CloudVendorService{
    private final CloudVendorRepository cloudVendorRepository;
    private final ModelMapper modelMapper;

    @Override
    public CreateCloudVendorResponse createCloudVendor(CreateCloudVendorRequest createCloudVendorRequest) {
        Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findByName(createCloudVendorRequest.getName());
        if (optionalCloudVendor.isPresent()) throw new CloudVendorAlreadyExistException("Cloud Vendor already exist");
        CloudVendor cloudVendor = modelMapper.map(createCloudVendorRequest, CloudVendor.class);
        cloudVendorRepository.save(cloudVendor);
        return CreateCloudVendorResponse.builder()
                .message("Cloud vendor has been created")
                .build();
    }
    @Override
    public GetCloudVendorResponse getCloudVendorById(Long vendorId) {
        Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findById(vendorId);
        if (optionalCloudVendor.isEmpty()) throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        // CloudVendor cloudVendor = optionalCloudVendor.get();
        return GetCloudVendorResponse.builder()
                .cloudVendor(optionalCloudVendor.get())
                .message("Requested Vendor Details are given here")
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
    @Override
    public UpdateCloudVendorResponse updateCloudVendor(Long vendorId, UpdateCloudVendorRequest updateCloudVendorRequest) {
        Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findById(vendorId);
        if (optionalCloudVendor.isEmpty()) throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        CloudVendor cloudVendor = optionalCloudVendor.get();
        modelMapper.map(updateCloudVendorRequest, cloudVendor);
        cloudVendorRepository.save(cloudVendor);
        return UpdateCloudVendorResponse.builder()
                .message("Cloud Vendor details has been updated")
                .build();
    }

    @Override
    public String deleteCloudVendorById(Long vendorId) {
        Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findById(vendorId);
        if (optionalCloudVendor.isEmpty()) throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        CloudVendor cloudVendor = optionalCloudVendor.get();
        cloudVendorRepository.delete(cloudVendor);
        return "Cloud Vendor has been deleted";
    }

    @Override
    public String deleteAllCloudVendors() {
        cloudVendorRepository.deleteAll();
        return "All Cloud Vendors has been deleted";
    }

}

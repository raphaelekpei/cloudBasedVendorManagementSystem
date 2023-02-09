package com.raphael.cloudbasedvendormanagementsystem.service;

import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
import com.raphael.cloudbasedvendormanagementsystem.data.repository.CloudVendorRepository;
import com.raphael.cloudbasedvendormanagementsystem.dtos.request.CreateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dtos.request.UpdateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dtos.response.CreateCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.dtos.response.UpdateCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.exceptions.CloudVendorManagementException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{
    private final CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public CreateCloudVendorResponse createCloudVendor(CreateCloudVendorRequest createCloudVendorRequest) {
        Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findByName(createCloudVendorRequest.getName());
        if (optionalCloudVendor.isPresent()){
            throw new CloudVendorManagementException("cloud vendor with the name " + createCloudVendorRequest.getName() + " already exist");
        }
        CloudVendor cloudVendor = new CloudVendor(
                createCloudVendorRequest.getName(),
                createCloudVendorRequest.getAddress(),
                createCloudVendorRequest.getPhoneNumber()
        );
        cloudVendorRepository.save(cloudVendor);
        CreateCloudVendorResponse createCloudVendorResponse = new CreateCloudVendorResponse();
        createCloudVendorResponse.setMessage("cloud vendor with the name " + createCloudVendorRequest.getName() + " has been successfully created");
        return createCloudVendorResponse;
    }
    @Override
    public CloudVendor getCloudVendorById(Long vendorId) {
        Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findById(vendorId);
        if (optionalCloudVendor.isEmpty()){
            throw new CloudVendorManagementException("cloud vendor with the id " + vendorId + " is not present");
        }
        return optionalCloudVendor.get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
    @Override
    public UpdateCloudVendorResponse updateCloudVendor(Long vendorId, UpdateCloudVendorRequest updateCloudVendorRequest) {
        Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findById(vendorId);
        if (optionalCloudVendor.isEmpty()){
            throw new CloudVendorManagementException("cloud vendor with the id " + vendorId + " does not exist");
        }
        CloudVendor cloudVendor = optionalCloudVendor.get();
        if (!updateCloudVendorRequest.getName().equals(cloudVendor.getName())){
            cloudVendor.setName(updateCloudVendorRequest.getName());
        }
        if (!updateCloudVendorRequest.getAddress().equals(cloudVendor.getAddress())){
            cloudVendor.setAddress(updateCloudVendorRequest.getAddress());
        }
        if (!updateCloudVendorRequest.getPhoneNumber().equals(cloudVendor.getPhoneNumber())){
            cloudVendor.setPhoneNumber(updateCloudVendorRequest.getPhoneNumber());
        }
        cloudVendorRepository.save(cloudVendor);
        UpdateCloudVendorResponse updateCloudVendorResponse = new UpdateCloudVendorResponse();
        updateCloudVendorResponse.setMessage("cloud vendor with the id " + vendorId + " has been updated successfully");
        return updateCloudVendorResponse;
    }

    @Override
    public void deleteCloudVendor(Long vendorId) {
        Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findById(vendorId);
        if (optionalCloudVendor.isEmpty()){
            throw new CloudVendorManagementException("cloud vendor with the id " + vendorId + " does not exist");
        }
        CloudVendor cloudVendor = optionalCloudVendor.get();
        cloudVendorRepository.delete(cloudVendor);
    }

    @Override
    public void deleteAllCloudVendors() {
        cloudVendorRepository.deleteAll();
    }
}

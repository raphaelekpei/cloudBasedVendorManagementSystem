package com.raphael.cloudbasedvendormanagementsystem.service;

import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
import com.raphael.cloudbasedvendormanagementsystem.data.repository.CloudVendorRepository;
import com.raphael.cloudbasedvendormanagementsystem.dto.request.CreateCloudVendorRequest;
import com.raphael.cloudbasedvendormanagementsystem.dto.response.CreateCloudVendorResponse;
import com.raphael.cloudbasedvendormanagementsystem.exception.CloudVendorAlreadyExistException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CloudVendorServiceImplTest {

    // Mock the dependencies (CloudVendorRepository and ModelMapper)
    @Mock
    private CloudVendorRepository cloudVendorRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CloudVendorServiceImpl cloudVendorService;

    CloudVendor cloudVendor;
    CreateCloudVendorRequest createCloudVendorRequest;

    @Captor
    private ArgumentCaptor<CloudVendor> cloudVendorCaptor;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // given that I have a createCloudVendorRequest & an empty cloud vendor
        createCloudVendorRequest = new CreateCloudVendorRequest("Amazon", "Address", "123456789");
        cloudVendor = new CloudVendor();

    }

    @AfterEach
    void tearDown() {

    }

    // This method verifies that when a vendor with the same name doesn't exist,
    // the service creates a new vendor, saves it using the repository, and returns the expected response.
    @Test
    void createCloudVendor_WhenVendorDoesNotEExist_ShouldCreateVendorAndReturnResponse() {
        // given
        when(cloudVendorRepository.findByName(createCloudVendorRequest.getName())).thenReturn(Optional.empty());
        when(modelMapper.map(createCloudVendorRequest, CloudVendor.class)).thenReturn(cloudVendor);

        // When
        CreateCloudVendorResponse createCloudVendorResponse = cloudVendorService.createCloudVendor(createCloudVendorRequest);

        // then assert
        assertNotNull(createCloudVendorResponse);
        assertEquals("cloud vendor has been created", createCloudVendorResponse.getMessage());

        // Verify that the cloudVendorRepository's save method was called with the cloudVendor object
        verify(cloudVendorRepository).save(cloudVendorCaptor.capture());
        CloudVendor savedCloudVendor = cloudVendorCaptor.getValue();
        assertEquals(createCloudVendorRequest.getName(), savedCloudVendor.getName());
        assertEquals(createCloudVendorRequest.getAddress(), savedCloudVendor.getAddress());
        assertEquals(createCloudVendorRequest.getPhoneNumber(), savedCloudVendor.getPhoneNumber());

    }


    // This method checks that when a vendor with the same name already exists, an exception is thrown, and the repository's save method is not called.

    @Test
    void createCloudVendor_WhenVendorExists_ShouldThrowException() {
        // Given
        when(cloudVendorRepository.findByName(createCloudVendorRequest.getName())).thenReturn(Optional.of(cloudVendor));

        // When & Then assert
        assertThrows(CloudVendorAlreadyExistException.class, () -> cloudVendorService.createCloudVendor(createCloudVendorRequest));

        // Verify that the cloudVendorRepository's save method was not called
        verify(cloudVendorRepository, never()).save(any());
    }


    @Test
    void getCloudVendorById() {
    }

    @Test
    void getAllCloudVendor() {
    }

    @Test
    void updateCloudVendor() {
    }

    @Test
    void deleteCloudVendorById() {
    }

    @Test
    void deleteAllCloudVendors() {
    }
}
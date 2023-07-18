//package com.raphael.cloudbasedvendormanagementsystem.service;
//
//import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
//import com.raphael.cloudbasedvendormanagementsystem.data.repository.CloudVendorRepository;
//import com.raphael.cloudbasedvendormanagementsystem.dto.request.CreateCloudVendorRequest;
//import com.raphael.cloudbasedvendormanagementsystem.dto.response.CreateCloudVendorResponse;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.modelmapper.ModelMapper;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//class CloudVendorServiceTest {
//
//    // the service should not be talking to the db
//    // mock the repository layer so that
//    @Mock
//    private CloudVendorRepository cloudVendorRepository;
//    //The purpose of Autocloseable is to close all unwanted resources when the class execution gets finished
//    CloudVendorService cloudVendorService;
//    private AutoCloseable autoCloseable;
//    CloudVendor cloudVendor;
//    CreateCloudVendorRequest createCloudVendorRequest;
//    CreateCloudVendorResponse createCloudVendorResponse;
//
//    @BeforeEach
//    void setUp() {
////        autoCloseable = Mockito.mock(AutoCloseable.class);
//        autoCloseable = MockitoAnnotations.openMocks(this);
//        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository, new ModelMapper());
//        cloudVendor = new CloudVendor("Amazon", "USA", "09093837491");
//
//    }
//
//    @AfterEach
//    void tearDown() throws Exception {
//        autoCloseable.close();
//    }
//
//    @Test
//    void createCloudVendorTest() {
//        mock(CloudVendor.class);
//        mock(CloudVendorRepository.class);
//        when(cloudVendorRepository.save(cloudVendor)).thenReturn(new Crea);
//        assertThat(cloudVendorService.createCloudVendor(new CreateCloudVendorRequest())).isEqualTo
//    }
//
//    @Test
//    void getCloudVendorById() {
//
//
//    }
//
//    @Test
//    void getAllCloudVendor() {
//    }
//
//    @Test
//    void updateCloudVendor() {
//    }
//
//    @Test
//    void deleteCloudVendorById() {
//    }
//
//    @Test
//    void deleteAllCloudVendors() {
//    }
//}
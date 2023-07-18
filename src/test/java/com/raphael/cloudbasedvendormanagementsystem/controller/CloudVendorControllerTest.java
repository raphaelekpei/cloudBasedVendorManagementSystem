package com.raphael.cloudbasedvendormanagementsystem.controller;

import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
import com.raphael.cloudbasedvendormanagementsystem.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest
class CloudVendorControllerTest {

    // Inject MockMvc because this is the web layer
    @Autowired
    private MockMvc mockMvc;

    // Mock cloud vendor service with the help of MockBean
    @MockBean
    private CloudVendorService cloudVendorService;
    // Create two instances of your entity
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    // Create a list of cloud vendors
    List<CloudVendor> cloudVendorList = new ArrayList<>();

    // initialize/populate
    @BeforeEach
    void setUp() {
     // initialize/populate the cloud vendors
    cloudVendorOne = new CloudVendor("Amazon", "USA", "09093837491");
    cloudVendorTwo = new CloudVendor("UK", "GCP", "09091949554");

    // add cloud vendors  to the cloud vendor list
    cloudVendorList.add(cloudVendorOne);
    cloudVendorList.add(cloudVendorOne);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createCloudVendor() {
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
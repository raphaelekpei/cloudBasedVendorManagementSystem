package com.raphael.cloudbasedvendormanagementsystem.repository;

import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
import com.raphael.cloudbasedvendormanagementsystem.data.repository.CloudVendorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CloudVendorRepositoryTest {
    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    // since we are dealing with a cloud vendor entity, we need to have a reference for that.
    private CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
       // given that I have a cloud vendor
        cloudVendor = new CloudVendor("Amazon", "USA", "09093837491");
       // and I save the cloud vendor in the db
        CloudVendor savedCloudVendor = cloudVendorRepository.save(cloudVendor);

    }

    @AfterEach
    void tearDown() {
        // after test execution, all resources should be deleted from the db
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }


    @Test
    void testFindByVendorName_Found(){
        // when I try to find the cloud vendor by its name in the db
        Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findByName("Amazon");
       // then assert that the cloud vendor is found
        assertTrue(optionalCloudVendor.isPresent());
       // when I try to extract/get the cloud vendor from the db
        CloudVendor foundCloudVendor = optionalCloudVendor.get();
        // then assert that the cloud vendor name I saved matches the cloud vendor name I got from the db
        assertEquals("Amazon", foundCloudVendor.getName());
      //  assertThat(foundCloudVendor.getName(), equalTo("Amazon"));

    }


    @Test
    void testFindByVendorName_NotFound(){
        // when I try to find the cloud vendor by its name in the db

        // when
        Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findByName("GCP");

        // then assert that the cloud vendor is not found
        assertThat(optionalCloudVendor.isEmpty(), equalTo(true));
        // assertTrue(optionalCloudVendor.isEmpty());
        // assertFalse(optionalCloudVendor.isPresent());

    }

}

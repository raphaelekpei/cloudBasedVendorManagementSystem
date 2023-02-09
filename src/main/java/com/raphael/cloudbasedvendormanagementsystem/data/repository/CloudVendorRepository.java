package com.raphael.cloudbasedvendormanagementsystem.data.repository;

import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface CloudVendorRepository extends JpaRepository<CloudVendor, Long> {
    Optional<CloudVendor> findByName(String name);
}

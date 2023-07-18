package com.raphael.cloudbasedvendormanagementsystem.dto.response;

import com.raphael.cloudbasedvendormanagementsystem.data.model.CloudVendor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class GetCloudVendorResponse {
    private String message;
    private CloudVendor cloudVendor;
    private HttpStatus status;

}

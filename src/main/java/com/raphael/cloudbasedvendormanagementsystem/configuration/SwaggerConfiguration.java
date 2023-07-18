package com.raphael.cloudbasedvendormanagementsystem.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Cloud Vendor APIs",
                version = "1.0.0",
                description = "This project is a cloud vendor management application",
                termsOfService = "developers choice",
                contact = @Contact(
                        name = "Raphael Ekpei Ojornelu",
                        email = "ekpeiraphael020@gmail.com",
                        url = "http://www.nelu.dev"
                ),
                license = @License(
                        name = "license",
                        url = "http://www.nelu.dev"
                )
        )
)
public class SwaggerConfiguration {


    // TODO: Swagger UI:  http://server:port/context-path/swagger-ui/index.html and
    // TODO: OpenAPI url for json format: http://server:port/context-path/v3/api-docs

}

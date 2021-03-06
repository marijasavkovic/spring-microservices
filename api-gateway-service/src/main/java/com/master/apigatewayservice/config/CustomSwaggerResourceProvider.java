package com.master.apigatewayservice.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.Arrays;
import java.util.List;

@Controller
@Primary
@ApiIgnore
@RefreshScope
public class CustomSwaggerResourceProvider implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
        return Arrays.asList(
                swaggerResource("employee-service", "/employee/api/v2/api-docs"),
                swaggerResource("level-of-studies-service", "/level-of-studies/api/v2/api-docs"),
                swaggerResource("department-service", "/department/api/v2/api-docs")
                //, swaggerResource("auth-service", "/auth/v2/api-docs")
        );
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource resource = new SwaggerResource();
        resource.setName(name);
        resource.setLocation(location);
        resource.setSwaggerVersion("2.0");
        return resource;
    }

}

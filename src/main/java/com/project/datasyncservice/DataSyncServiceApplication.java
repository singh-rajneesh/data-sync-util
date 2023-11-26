package com.project.datasyncservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"com.farmrise.orderintentservice", "com.climate"}, exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class, ContextRegionProviderAutoConfiguration.class})
@OpenAPIDefinition(info = @Info(title = "Order Intent Service API", version = "1.0.0"))
public class DataSyncServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataSyncServiceApplication.class, args);
    }

}
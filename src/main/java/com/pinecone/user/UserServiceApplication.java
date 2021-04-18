package com.pinecone.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.pincone.serviceclients.DepartmentClient;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = {DepartmentClient.class})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("PineCone User Service").description("Api documentation for pinecone ")
                .version("v2.0.0").license(new License().name("Apache 2.0").url("http://dev.pinecone.com")));
    }

}

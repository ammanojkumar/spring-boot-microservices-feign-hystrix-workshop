package io.mk.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@SpringBootApplication
@EnableFeignClients
//@EnableHystrix
public class InsuranceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceServiceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}

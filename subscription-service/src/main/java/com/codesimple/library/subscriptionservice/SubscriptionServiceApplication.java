package com.codesimple.library.subscriptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class SubscriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionServiceApplication.class, args);
	}
	
	/*** REST TEMPLATE IMPLEMENTATION ***/
	//@Bean
	//RestTemplate restTemplate() 
	//{
	//    return new RestTemplate();
	//}
}

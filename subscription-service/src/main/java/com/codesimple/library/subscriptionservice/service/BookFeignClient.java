package com.codesimple.library.subscriptionservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="BOOK-SERVICE")
public interface BookFeignClient {
	@GetMapping("/books/{bookId}/availableforsubscription")
	public boolean isAvailableForSubscription(@PathVariable String bookId);
	
	@PostMapping("/books/{bookId}/subscribe")
	public boolean subscribe(@PathVariable String bookId);
}

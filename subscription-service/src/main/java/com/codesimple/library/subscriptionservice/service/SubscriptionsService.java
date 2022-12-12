package com.codesimple.library.subscriptionservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codesimple.library.subscriptionservice.entity.Subscription;
import com.codesimple.library.subscriptionservice.repository.SubscriptionsRepository;

@Service
public class SubscriptionsService {
	@Autowired
	SubscriptionsRepository subscriptionsRepository;
	
	/*** REST TEMPLATE IMPLEMENTATION ***/
	//@Autowired
	//RestTemplate restTemplate;
	
	//Feign Client Implementation
	@Autowired
    private BookFeignClient bookFeignClient;
	
	public List<Subscription> getAllSubscriptions()
	{
		return subscriptionsRepository.findAll();
	}
	
	public List<Subscription> getSubscriptionsByBookId(String bookId)
	{
		return subscriptionsRepository.findByBookId(bookId);
	}
	
	public List<Subscription> getSubscriptionsBySubscriberName(String subscriberName)
	{
		return subscriptionsRepository.findBySubscriberName(subscriberName);
	}
	
	public Subscription saveSubscription(Subscription subscription)
	{
		String bookId = subscription.getBookId();

		//http://localhost:9081/books/B1001/availableforsubscription (GET)	//Book Service
		//http://localhost:8080/books/B1001/availableforsubscription (GET)	//Book Service from Gateway
		
		/*** REST TEMPLATE IMPLEMENTATION ***/
		//String url = String.format("http://localhost:8080/books/%s/availableforsubscription",bookId);
        //boolean isAvailable = restTemplate.getForObject(url, Boolean.class);

		//Feign Client Implementation
		boolean isAvailable = bookFeignClient.isAvailableForSubscription(bookId);
        if (isAvailable)
        {
    		//http://localhost:9081/books/B1001/subscribe (GET)	//Book Service
    		//http://localhost:8080/books/B1001/subscribe (GET)	//Book Service from Gateway

        	/*** REST TEMPLATE IMPLEMENTATION ***/
        	//String urlSubscribe = String.format("http://localhost:8080/books/%s/subscribe",bookId);
            //boolean subscribed = restTemplate.postForObject(urlSubscribe, null, Boolean.class);
            //boolean subscribed = restTemplate.postForObject(urlSubscribe, null, Boolean.class);

        	//Feign Client Implementation
        	boolean subscribed = bookFeignClient.subscribe(bookId);
        	
            if (subscribed)
            	subscription = subscriptionsRepository.save(subscription);
        }
		
		return subscription;
	}
}

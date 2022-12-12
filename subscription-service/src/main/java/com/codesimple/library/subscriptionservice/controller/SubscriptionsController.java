package com.codesimple.library.subscriptionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesimple.library.subscriptionservice.entity.Subscription;
import com.codesimple.library.subscriptionservice.service.SubscriptionsService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionsController {
	@Autowired
	SubscriptionsService subscriptionsService;
	
	@GetMapping()
    public ResponseEntity<List<Subscription>> getSubscriptionsBySubscriberName(@RequestParam (required = false) String subscriberName){
		if (subscriberName == null)
		{
			return new ResponseEntity<List<Subscription>>(subscriptionsService.getAllSubscriptions(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Subscription>>(subscriptionsService.getSubscriptionsBySubscriberName(subscriberName), HttpStatus.OK);
		}
    }

	@GetMapping("{bookId}")
    public ResponseEntity<List<Subscription>> getSubscriptionsByBookId(@PathVariable String bookId){
		return new ResponseEntity<List<Subscription>>(subscriptionsService.getSubscriptionsByBookId(bookId), HttpStatus.OK);
    }
	
	@PostMapping()
    public ResponseEntity<Subscription>  createBook(@RequestBody Subscription subscription){
		subscription = subscriptionsService.saveSubscription(subscription);
		HttpStatus status = HttpStatus.CREATED;
		
		if (subscription.getSubscriptionId() == 0)
			status = HttpStatus.UNPROCESSABLE_ENTITY;
		
		return new ResponseEntity<Subscription>(subscriptionsService.saveSubscription(subscription), status);
    }

}

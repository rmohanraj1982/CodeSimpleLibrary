package com.codesimple.library.subscriptionservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codesimple.library.subscriptionservice.entity.Subscription;

public interface SubscriptionsRepository extends JpaRepository<Subscription, String> 
{
	List<Subscription> findBySubscriberName(String subscriberName);
	List<Subscription> findByBookId(String bookId);
}

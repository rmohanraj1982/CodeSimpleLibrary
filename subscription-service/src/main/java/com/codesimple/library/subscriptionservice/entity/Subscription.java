package com.codesimple.library.subscriptionservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SUBSCRIPTIONS")
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_id")
	public long subscriptionId;

	@Column(name = "subscriber_name", length = 10)
	public String subscriberName;
	
	@Column(name = "book_id", length = 10)
	public String bookId;
	
	@Column(name = "date_subscribed")
	public String dateSubscribed;

	@Column(name = "date_returned")
	public String dateReturned;
}

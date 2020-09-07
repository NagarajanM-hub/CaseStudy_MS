package com.casestudy.demo.library.model;

import javax.persistence.*;

@Entity
@Table(name="SUBSCRIPTION")
public class Subscription {
	@Id
    @Column(name = "SUBSCRIBER_NAME")
	private String subscriberName;
    
    @Column(name = "DATE_SUBSCRIBED")
	private String subscriptionDate;
    
    @Column(name = "DATE_RETURNED")
	private String returnedDate;
    
    @Column(name = "BOOK_ID")
	private long bookId;

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public String getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(String subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public String getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(String returnedDate) {
		this.returnedDate = returnedDate;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

}
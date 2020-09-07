package com.casestudy.demo.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.casestudy.demo.library.model.Subscription;

public interface SubscriberRepository extends CrudRepository<Subscription, Long> {
	
	@Override
    List<Subscription> findAll();
	
	List<Subscription> findBySubscriberName(String subscriberName);
	
	List<Subscription> findBySubscriberNameAndBookId(String subscriberName, String bookId);
}
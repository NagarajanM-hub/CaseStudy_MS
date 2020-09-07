package com.casestudy.demo.library.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.casestudy.demo.library.model.Book;
import com.casestudy.demo.library.model.Subscription;
import com.casestudy.demo.library.repository.SubscriberRepository;
import com.casestudy.demo.library.util.DateUtil;

@Service
public class SubscriptionService {
	Logger logger = LoggerFactory.getLogger(SubscriptionService.class.getName());
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	public List<Subscription> retrieveSubscriptions() {
		List<Subscription> subscribersList = subscriberRepository.findAll();
		return subscribersList ;
	}
	
	@Transactional
	public Subscription subscription(int bookId, Subscription subscription) {
		List<Book> response = bookService.getBookDetails(bookId);
		
		for (Book book : response) {
			if (book.getId() == bookId) {
				if(book.getAvailableCopies() > 0) {
					try {
						subscription.setBookId(bookId);
						String date = DateUtil.getFormattedDate(new Date(), "dd-MON-YYYY");
						subscription.setSubscriptionDate(date);
						book.setAvailableCopies(book.getAvailableCopies()-1);
						bookService.save(book);
						subscriberRepository.save(subscription);
					} catch(Exception ex) {
						throw new RuntimeException("Book is not available this time, please check later");
					}
					
				} else {
					throw new RuntimeException("Book is not available this time, please check later");
				}
				break;
			}
		}
		
		return subscription;
	}
	
	@Transactional
	public Subscription unsubscription(int bookId, String subscriberName) {
		
		List<Subscription> response = subscriberRepository.findBySubscriberName(subscriberName);
		List<Book> books = bookService.getBookDetails(bookId);
		Book book = books.get(0);
		book.setAvailableCopies(book.getAvailableCopies()+1);
		
		for(Subscription s: response) {
			if(s.getBookId() == bookId) {
				String date = DateUtil.getFormattedDate(new Date(), "dd-MON-YYYY");
				s.setReturnedDate(date);
				subscriberRepository.save(s);
				bookService.save(book);
				return s;
			} else {
				continue;
			}
		}
		
		
		return null;
	}
	
	/*public Subscription fallbackForSubscription(@PathVariable String bookname, @PathVariable String author, @PathVariable String subscribername) {
		logger.debug("Book is not available this time, please check later");
		return new Subscription(0L, subscribername, null, null, "Book is not available this time, please check later");
    }
	
	public Subscription fallbackForUnsubscription(@PathVariable String bookname, @PathVariable String author, @PathVariable String subscribername) {
		logger.debug("Either this user is not associated with this book or already unscribed");
		return new Subscription(0L, subscribername, null, null, "Either this user is not associated with this book or already unscribed");
	}*/
}

package com.casestudy.demo.library.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.demo.library.model.Book;
import com.casestudy.demo.library.repository.BookRepository;


@Service
public class BookService {
	
	@Autowired
    private BookRepository bookRepo;
	
	public List<Book> getBookDetails(int bookId)
	{
		
		List<Book> list = bookRepo.findById(bookId);
		return list;
	}

	public void save(Book book) {
		bookRepo.save(book);
		
	}

	
}

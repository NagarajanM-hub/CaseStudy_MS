package com.casestudy.demo.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.demo.library.model.Book;
import com.casestudy.demo.library.service.BookService;

@RestController
//@CrossOrigin(origins = "http://localhost:9200")
@RequestMapping("/books")
public class BooksController {
	
    @Autowired
    BookService bookService;

	@GetMapping("/availableCopies/{id}")
	//@CrossOrigin(origins = "http://localhost:9200")
    public int getAvailableCopiesCount(@PathVariable(value = "id") int id)
    {
		 
		try {
			List<Book> book = bookService.getBookDetails(id);
			System.out.println("book::"+book.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return 5;
		 
    }
	
	@PostMapping("/avlCopies")
	//@CrossOrigin(origins = "http://localhost:9200")
    public int getAvlCopiesCount()
    {
		 
		try {
			List<Book> book = bookService.getBookDetails(100);
			System.out.println("book::"+book.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return 5;
		 
    }
    
    //@CrossOrigin(origins = "http://localhost:4200")
	/*@PostMapping("/add")
	public addResponse AddCard(@RequestBody addRequest account) throws Exception
	{		 
		return accountService.Add(account);
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/list")
	public List<Account> listCards(@RequestBody listRequest listReq) throws Exception
	{		 
		return accountService.listCards(listReq);
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/balance")
	public balanceResponse Balance(@RequestBody balanceRequest balanceRequest) throws Exception
	{		 
		return accountService.getBalance(balanceRequest);
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/withdraw")
	public withdrawResponse Cashwithdrawal(@RequestBody withdrawRequest withdrawRequest) throws Exception
	{
			 
		return accountService.Cashwithdrawal(withdrawRequest);
	}
	
	// @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/deposit")
	public depositResponse Cashdeposit(@RequestBody depositRequest depositRequest) throws Exception
	{	 
		return accountService.Cashdeposit(depositRequest);
	}*/
}

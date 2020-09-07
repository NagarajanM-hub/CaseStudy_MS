package com.casestudy.demo.library.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.demo.library.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	public List<Book> findById(int bookId);

	//public List<Book> findAllByUsername(String username);
}

package com.example.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	// IN CASE OF COMPLICATED SQL QUERIES CAN USE @QUERY
	//@Query("SELECT * FROM student")
    
}
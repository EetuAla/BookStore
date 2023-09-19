package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("Save a couple of categories");
			Category fictionCategory = new Category("Fiction");
			Category dramaCategory = new Category("Drama");
			categoryRepository.save(fictionCategory);
			categoryRepository.save(dramaCategory);

			log.info("Save a couple of books with categories");
			Book book1 = new Book("Bookone", "Authorone", 2023, "A-23124", 15.90);
			book1.setCategory(fictionCategory);
			repository.save(book1);

			Book book2 = new Book("Booktwo", "Authortwo", 2022, "A-23321", 17.90);
			book2.setCategory(dramaCategory);
			repository.save(book2);

			log.info("Fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}

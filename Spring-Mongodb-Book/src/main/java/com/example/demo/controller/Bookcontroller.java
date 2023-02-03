package com.example.demo.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@RestController
public class Bookcontroller {

	@Autowired
	private BookRepository repository;

	@PostMapping("/addBook")
	public ResponseEntity<?> saveBook(@RequestBody Book book) {
		Book save=this.repository.save(book);
		return ResponseEntity.ok(save) ;
	}

	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return repository.findAll();
	}

	@GetMapping("/find/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return repository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "The book got deleted";
	}

}

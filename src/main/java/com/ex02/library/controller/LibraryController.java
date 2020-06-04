package com.ex02.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex02.library.model.BookEntity;
import com.ex02.library.model.LibraryEntity;
import com.ex02.library.model.UserEntity;
import com.ex02.library.service.LibraryServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;


@RestController
public class LibraryController {

	@Autowired
	private LibraryServiceImpl  libraryServiceImpl;

	
	@PostMapping("/library")
	public LibraryEntity borrowBooks(@RequestBody ObjectNode json ) {
	
		UserEntity user = new UserEntity();
				   user.setIdUser( json.get("id_user").asInt() );
				   user.setName  ( json.get("name").asText() );
		
		BookEntity book = new BookEntity();
				book.setIdBook( json.get("id_book").asInt() );
				book.setAuthor( json.get("author").asText() );
				book.setTitle  ( json.get("title").asText() );
				  
		return libraryServiceImpl.borrowBooks(book, user);
	}
	
	@PostMapping("/books")
	public String addBooks(@RequestBody List<BookEntity> books) {
		
		libraryServiceImpl.addNewBooks(books);
		
		return "The book has added";	
	}	
	
}

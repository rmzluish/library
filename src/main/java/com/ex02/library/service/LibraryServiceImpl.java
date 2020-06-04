package com.ex02.library.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex02.library.model.BookEntity;
import com.ex02.library.model.LibraryEntity;
import com.ex02.library.model.UserEntity;
import com.ex02.library.repository.BookRepository;
import com.ex02.library.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public LibraryEntity borrowBooks(BookEntity book, UserEntity user) {
		
		LibraryEntity library = new LibraryEntity();
		library.setUser(user);
		library.setBook(book);
		
		return libraryRepository.save(library);
	}

	@Override
	public List<BookEntity> addNewBooks(List<BookEntity> books) {
		
		Iterator<BookEntity> listBooks = books.iterator();
		
		while (listBooks.hasNext()) {
			BookEntity currentBook = listBooks.next();
			
			bookRepository.save(currentBook);
		}

		return books;
	}
	
}

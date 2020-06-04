package com.ex02.library.service;

import java.util.List;

import com.ex02.library.model.BookEntity;
import com.ex02.library.model.LibraryEntity;
import com.ex02.library.model.UserEntity;

interface LibraryService {
	public LibraryEntity borrowBooks(BookEntity book, UserEntity user);
	public List<BookEntity> addNewBooks(List<BookEntity> books);
}

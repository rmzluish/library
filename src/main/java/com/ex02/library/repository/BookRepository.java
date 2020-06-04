package com.ex02.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex02.library.model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{
	
}

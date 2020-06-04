package com.ex02.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex02.library.model.LibraryEntity;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {
	
}

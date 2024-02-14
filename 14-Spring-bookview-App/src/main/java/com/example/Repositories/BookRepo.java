package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Books;

public interface BookRepo extends JpaRepository<Books, Integer>{

}

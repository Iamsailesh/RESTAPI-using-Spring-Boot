package com.jp.practicerest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.practicerest.entities.Books;


public interface BookRepository extends JpaRepository<Books, Integer> {
    Books findByBid(int bid);
}

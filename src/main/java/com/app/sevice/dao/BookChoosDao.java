package com.app.sevice.dao;

import com.app.domain.Book;
import com.app.domain.BookChoos;
import com.app.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookChoosDao extends JpaRepository<BookChoos, Integer> {

    public BookChoos findByBook(Book book);
}

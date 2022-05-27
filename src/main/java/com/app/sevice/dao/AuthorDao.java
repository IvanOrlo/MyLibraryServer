package com.app.sevice.dao;

import com.app.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Integer> {

    // SELECT * FROM author WHERE name = ?
    Author findByName(String name);
}

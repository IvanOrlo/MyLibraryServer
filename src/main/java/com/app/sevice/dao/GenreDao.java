package com.app.sevice.dao;

import com.app.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre, Integer> {

    // SELECT * FROM genre WHERE name = ?
    Genre findByName(String name);
}

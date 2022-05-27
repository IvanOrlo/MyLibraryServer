package com.app.sevice;

import com.app.domain.Book;
import com.app.domain.BookChoos;
import com.app.domain.User;

import java.util.List;

public interface ChosenBookService {
    BookChoos insert(int book_id);

    BookChoos update(int id,
                String nameBook,
                String nameGenre,
                String nameAuthor);

    List<BookChoos> getAll();

    BookChoos getById(int id);

    BookChoos getByName(String name);

    void deleteById(int id);

    BookChoos getByBook(Book book);
}

package com.app.sevice;

import com.app.domain.*;
import com.app.sevice.dao.AuthorDao;
import com.app.sevice.dao.BookChoosDao;
import com.app.sevice.dao.BookDao;
import com.app.sevice.dao.GenreDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChosenBookServiceImpl implements ChosenBookService {

    private final GenreDao genreDao;
    private final BookChoosDao bookChoosDao;
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookChoos insert(int book_id){
        BookChoos bookChoos = new BookChoos();
        bookChoos.setBook(bookDao.findById(book_id));
        return bookChoosDao.save(bookChoos);
    }


    @Override
    @Transactional
    public BookChoos update(int id,
                       String nameBook,
                       String nameLocation,
                       String nameAuthor) {


        return bookChoosDao.save(new BookChoos());
    }

    @Override
    public List<BookChoos> getAll() {

        return bookChoosDao.findAll();
    }

    @Override
    public BookChoos getById(int id) {
        return null;
    }

    @Override
    public BookChoos getByName(String name) {
        return null;
    }


    @Transactional
    @Override
    public void deleteById(int id) {

        bookChoosDao.deleteById(id);
    }

    @Override
    public BookChoos getByBook(Book book) {
        return bookChoosDao.findByBook(book);
    }
}

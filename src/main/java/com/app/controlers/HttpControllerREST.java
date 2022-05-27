package com.app.controlers;


import com.app.AuthBody;
import com.app.BookBody;
import com.app.ResponseExample;
import com.app.domain.Book;
import com.app.domain.BookChoos;
import com.app.domain.User;
import com.app.sevice.AuthorService;
import com.app.sevice.BookService;
import com.app.sevice.ChosenBookService;
import com.app.sevice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
public class HttpControllerREST extends HttpServlet {
    private final BookService bookService;
    private final UserService userService;
    private final ChosenBookService chosenBookService;
    private final AuthorService authorService;


    // получем имя и пароль юзера
    User user = new User();

    @ResponseBody
        @PostMapping("auth/login")
    public User checkUser(@RequestBody AuthBody request, HttpServletResponse response) {
        User u = new User();
        String login = request.getLogin();
        String pwd = request.getPassword();
        System.out.println(login + "  " + pwd);
        u.setName(login);
        u.setPassword(pwd);

        user = userService.getByNameAndPassword(login, pwd);
        if(user ==null) {
            user = userService.insert(u);
            return user;
        }
        return user;
    }

    @PostMapping("/book")
    public Book saveBook(@RequestBody BookBody bookRequest, HttpServletResponse response) {
        Book pp = bookService.insert(bookRequest.getName(), bookRequest.getLocation(), bookRequest.getAuthor());

        System.out.println(pp);
        return pp;
    }

    @PostMapping("/chosenBook")
    public BookChoos choosBook(@RequestBody BookBody bookRequest, HttpServletResponse response) {
        BookChoos sp = new BookChoos();
        Book book = bookService.insert(bookRequest.getName(), bookRequest.getLocation(), bookRequest.getAuthor());
        int book_id = bookRequest.getId();
        if (chosenBookService.getByBook(book)!=null) {

            sp = chosenBookService.insert(book_id);

        }
        System.out.println("поступил заказ от " + user.getName()+" "+ user.getPassword()+" на "+bookRequest.getName());
        return sp;

    }

}

package com.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    private int id;

    @Column(name = "name")
    private String name;


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book") // Вид связи один ко многим (у одной книги много комментов)
//    private String location;

    @ManyToOne(targetEntity = Author.class, fetch = FetchType.LAZY) // Вид связи многое к одному (у одного автора
    @JoinColumn(name = "author_id")                                 // много книг), выгружаем автора, когда необходимо
    private Author author;

//    @JoinColumn(name = "author_id")                                 // много книг), выгружаем автора, когда необходимо
//    private Author author;

    @ManyToOne(targetEntity = Genre.class, fetch = FetchType.LAZY) // Вид связи многое к одному (у одного жанра
    @JoinColumn(name = "genre_id")                                 // много книг), выгружаем жанр, когда необходимо
    private Genre genre;


    @OneToOne(mappedBy = "book")// Вид связи многое к одному (у одной библиотеки
    // много книг), выгружаем библиотеку, когда необходимо
    private BookChoos bookChoos;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                '}';
    }
}

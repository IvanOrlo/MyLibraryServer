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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "user")                               // много книг), выгружаем библиотеку, когда необходимо
    private BookChoos bookChoos;
}

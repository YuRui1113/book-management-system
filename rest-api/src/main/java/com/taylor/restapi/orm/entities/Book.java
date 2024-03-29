/*
 * File: src\main\java\com\taylor\restapi\orm\entities\Book.java
 * Project: Rest-API
 * Created Date: Sunday, February 25th 2024, 6:21:15 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Tuesday, 26th March 2024 4:06:13 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2024 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Sunday, February 25th 2024	Rui Yu		Initial version
 */

package com.taylor.restapi.orm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "books", schema = "public")
@Getter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @Setter
    @Column(name = "title", nullable = false, length = 250)
    private String title;

    @Setter
    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @Setter
    @Column(name = "publicationYear", nullable = true)
    private Short publicationYear;

    @Setter
    @Column(name = "isbn", nullable = false, unique = true, length = 20)
    private String isbn;

    protected Book() {
    }

    public Book(String title, String author, Short publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    // For unit test
    public Book(Long id, String title, String author, Short publicationYear, String isbn) {
        this(title, author, publicationYear, isbn);
        this.id = id;
    }
}
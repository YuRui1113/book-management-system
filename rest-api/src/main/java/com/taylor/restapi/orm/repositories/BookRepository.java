/*
 * File: src\main\java\com\taylor\restapi\orm\repositories\BookRepository.java
 * Project: Rest-API
 * Created Date: Sunday, February 25th 2024, 6:35:07 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Wednesday, 13th March 2024 9:09:49 am
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2024 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Sunday, February 25th 2024	Rui Yu		Initial version
 */

package com.taylor.restapi.orm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taylor.restapi.orm.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);

    @Query("SELECT b FROM Book b WHERE b.id != :id AND b.isbn = :isbn")
    Optional<Book> findByIsbnExcludeCurrent(@Param("id") Long id, @Param("isbn") String isbn);
}
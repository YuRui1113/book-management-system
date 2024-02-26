/*
 * File: src\main\java\com\taylor\infosys\restapi\services\BookService.java
 * Project: Rest-API
 * Created Date: Sunday, February 25th 2024, 6:36:54 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Monday, 26th February 2024 10:01:33 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2024 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Sunday, February 25th 2024	Rui Yu		Initial version
 */

package com.taylor.infosys.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.taylor.infosys.restapi.exceptions.ResourceAlreadyExistsException;
import com.taylor.infosys.restapi.exceptions.ResourceNotFoundException;
import com.taylor.infosys.restapi.orm.entities.Book;
import com.taylor.infosys.restapi.orm.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book createBook(Book book) {
        Optional<Book> existedBook = repository.findByIsbn(book.getIsbn());
        if (existedBook.isPresent()) {
            throw new ResourceAlreadyExistsException("Book with ISBN: " + book.getIsbn() +
                    " already exists!");
        }

        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Page<Book> getBooksByPage(Optional<Integer> page, Optional<Integer> size) {
        Pageable pageable = PageRequest.of(0, 10,
                Sort.by(Sort.Direction.DESC, "id"));
        if (page.isPresent() && size.isPresent()) {
            pageable = PageRequest.of(page.get(), size.get(),
                    Sort.by(Sort.Direction.DESC, "id"));
        }

        return repository.findAll(pageable);
    }

    public Book getBookById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not exists with id: " + id));
    }

    public Book updateBook(Long id, Book book) {
        if (repository.findByIsbnExcludeCurrent(book.getId(), book.getIsbn()).isPresent()) {
            throw new ResourceAlreadyExistsException("Book with ISBN: " + book.getIsbn() +
                    " already exists!");
        }

        Book existedBook = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not exists with id: " + id));

        existedBook.setTitle(book.getTitle());
        existedBook.setAuthor(book.getAuthor());
        existedBook.setPublicationYear(book.getPublicationYear());
        existedBook.setIsbn(book.getIsbn());

        return repository.save(existedBook);
    }

    public void deleteStuduent(Long id) {
        Book existedBook = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not exists with id: " + id));
        repository.delete(existedBook);
    }
}
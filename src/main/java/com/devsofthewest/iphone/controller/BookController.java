package com.devsofthewest.iphone.controller;

import com.devsofthewest.iphone.model.Book;
import com.devsofthewest.iphone.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.google.common.collect.Lists;

@RestController
public class BookController
{

@Autowired
BookRepository bookRepository;
  @GetMapping("/books/getAll")
  public String findAllBooks() {
     Iterable<Book> books = this.bookRepository.findAll();
     return Lists.newArrayList(books).toString();
  }
  @GetMapping("/hello")
  public String hello2() {
      return "HELLO FRIENDS";
  }


}
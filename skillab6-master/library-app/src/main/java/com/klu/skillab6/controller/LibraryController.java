package com.klu.skillab6.controller;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryController {


List<Book> bookList = new ArrayList<>();

// 1. Welcome message
@GetMapping("/welcome")
public String welcome() {
    return "Welcome to the Library System";
}

// 2. Total books count
@GetMapping("/count")
public int count() {
    return 100;
}

// 3. Book price
@GetMapping("/price")
public double price() {
    return 499.99;
}

// 4. List of book titles
@GetMapping("/books")
public List<String> books() {
    List<String> titles = new ArrayList<>();
    titles.add("Spring Boot Guide");
    titles.add("Java Programming");
    titles.add("Microservices with Spring");
    return titles;
}

// 5. Book by ID
@GetMapping("/books/{id}")
public String getBookById(@PathVariable int id) {
    return "Book details for ID: " + id;
}

// 6. Search book by title
@GetMapping("/search")
public String searchBook(@RequestParam String title) {
    return "Searching for book: " + title;
}

// 7. Author name
@GetMapping("/author/{name}")
public String author(@PathVariable String name) {
    return "Books written by author: " + name;
}

// 8. Add new book
@PostMapping("/addbook")
public String addBook(@RequestBody Book book) {
    bookList.add(book);
    return "Book added successfully";
}

// 9. View all books
@GetMapping("/viewbooks")
public List<Book> viewBooks() {
    return bookList;
}


}

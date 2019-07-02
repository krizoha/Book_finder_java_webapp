package cz.java_webapp.book_finder;

import java.sql.*;
import java.util.*;
import org.mariadb.jdbc.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.lookup.*;

public class BookRepository {

    MariaDbDataSource configuration = new MariaDbDataSource();
    JdbcTemplate queryDispatcher;
    RowMapper<Book> converter;
    List<Book> listOfBooks;

    public BookRepository() {
        try {
            configuration.setUserName("student");
            configuration.setPassword("password");
            configuration.setUrl("jdbc:mysql://localhost:3306/book_database");

            queryDispatcher = new JdbcTemplate(configuration);
            converter = BeanPropertyRowMapper.newInstance(Book.class);
        } catch (SQLException e) {
            throw new DataSourceLookupFailureException("DataSource failed", e);
        }
    }

    public synchronized List<Book> findByAuthor(String authorOfBook) {
        listOfBooks = queryDispatcher.query("select id, name, author, genre, publisher, date_of_publication as dateOfPublication, ISBN from book where author=?", converter, authorOfBook);
        return listOfBooks;
    }

    public synchronized List<Book> findByName(String nameOfBook) {
        listOfBooks = queryDispatcher.query("select id, name, author, genre, publisher, date_of_publication as dateOfPublication, ISBN from book where name=?", converter, nameOfBook);
        return listOfBooks;
    }

    public synchronized List<Book> findByGenre(String genreOfBook) {
        listOfBooks = queryDispatcher.query("select id, name, author, genre, publisher, date_of_publication as dateOfPublication, ISBN from book where genre=?", converter, genreOfBook);
        return listOfBooks;
    }

    public synchronized List<Book> findByPublisher(String publisherOfBook) {
        listOfBooks = queryDispatcher.query("select id, name, author, genre, publisher, date_of_publication as dateOfPublication, ISBN from book where publisher=?", converter, publisherOfBook);
        return listOfBooks;
    }

    public synchronized List<Book> findByYear(String yearOfBook) {
        listOfBooks = queryDispatcher.query("select id, name, author, genre, publisher, date_of_publication as dateOfPublication, ISBN from book where date_of_publication=?", converter, yearOfBook);
        return listOfBooks;
    }

    public synchronized List<Book> findByISBN(String isbnOfBook) {
        listOfBooks = queryDispatcher.query("select id, name, author, genre, publisher, date_of_publication as dateOfPublication, ISBN from book where ISBN=?", converter, isbnOfBook);
        return listOfBooks;
    }

    public synchronized List<Book> findAll() {
        listOfBooks = queryDispatcher.query("select id, name, author, genre, publisher, date_of_publication as dateOfPublication, ISBN " + " from book", converter);
        return listOfBooks;
    }

}

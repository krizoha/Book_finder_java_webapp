package cz.java_webapp.book_finder;

public class Book {

    private Long id;
    private String name;
    private String author;
    private String genre;
    private String publisher;
    private String dateOfPublication;
    private String ISBN;

    public Long getId() {
        return id;
    }

    public void setId(Long newValue) {
        id = newValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newValue) {
        author = newValue;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String newValue) {
        genre = newValue;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String newValue) {
        publisher = newValue;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String newValue) {
        dateOfPublication = newValue;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String newValue) {
        ISBN = newValue;
    }

    public Book(Long id, String name, String author, String genre, String publisher, String dateOfPublication, String ISBN) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.dateOfPublication = dateOfPublication;
        this.ISBN = ISBN;
    }

    public Book() {

    }

}

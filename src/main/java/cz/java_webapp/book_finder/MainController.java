package cz.java_webapp.book_finder;

import java.sql.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class MainController {

    BookRepository bookRepository = new BookRepository();

    @RequestMapping("/")
    public ModelAndView showIndex() {
        return new ModelAndView("redirect:/index.html");
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView showIndex2() {
        ModelAndView dataHodler = new ModelAndView("index");
        return dataHodler;
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.POST)
    public ModelAndView showResult(IndexForm entryData) {
        ModelAndView dataHodler = new ModelAndView("result");
        String chyba;

        if (entryData.getAuthor() != null && !entryData.getAuthor().isEmpty()) {
            dataHodler.addObject("book", bookRepository.findByAuthor(entryData.getAuthor()));
            return dataHodler;
        } else if (entryData.getGenre() != null && !entryData.getGenre().isEmpty()) {
            dataHodler.addObject("book", bookRepository.findByGenre(entryData.getGenre()));
            return dataHodler;
        } else if (entryData.getPublisher() != null && !entryData.getPublisher().isEmpty()) {
            dataHodler.addObject("book", bookRepository.findByPublisher(entryData.getPublisher()));
            return dataHodler;
        } else if (entryData.getDateOfPublication() != null && !entryData.getDateOfPublication().isEmpty()) {
            dataHodler.addObject("book", bookRepository.findByYear(entryData.getDateOfPublication()));
            return dataHodler;
        } else if (entryData.getIsbn() != null && !entryData.getIsbn().isEmpty()) {
            dataHodler.addObject("book", bookRepository.findByISBN(entryData.getIsbn()));
            return dataHodler;
        } else if (entryData.getName() != null && !entryData.getName().isEmpty()) {
            dataHodler.addObject("book", bookRepository.findByName(entryData.getName()));
            return dataHodler;
        } else {
            ModelAndView error = new ModelAndView("errorPage");
            return error;
        }

    }

    @RequestMapping(value = "/listOfBooks.html")
    public ModelAndView showListOfBooks() {
        ModelAndView dataHodler = new ModelAndView("listOfBooks");
        dataHodler.addObject("all", bookRepository.findAll());
        return dataHodler;
    }

}

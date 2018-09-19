package ua.yava.library.spring.controller;

import lombok.extern.java.Log;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.yava.library.dao.impl.BookService;

import javax.servlet.http.HttpServletResponse;

@Controller
@Log
public class RedirectController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse response) {

        bookService.vote(bookService.get(33), 5);

        return "ok";
    }

}

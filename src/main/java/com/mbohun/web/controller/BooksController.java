package com.mbohun.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mbohun.dao.BookDao;
import com.mbohun.model.Book;

@Controller
public class BooksController {

	private static final Logger logger = LoggerFactory.getLogger(BooksController.class);

	@Autowired
	CustomerDao bookDao;
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String books(Model model) {
		List<Book> books = bookDao.findAll();
		System.out.println(books);
		model.addAttribute("books", books);
		return "books";
	}

}

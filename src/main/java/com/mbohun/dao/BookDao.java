package com.mbohun.dao;

import java.util.List;

import com.mbohun.model.Book;

public interface BookDao {
	List<Book> findAll();
}

package com.mbohun.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mbohun.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Book> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM books";

		List<Book> result = namedParameterJdbcTemplate.query(sql, params, new BookMapper());
        return result;
	}

	private static final class BookMapper implements RowMapper<Book> {
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = new Book();
			book.setIsbn(rs.getLong("isbn"));
			book.setAuthor(rs.getString("author"));
			book.setTitle(rs.getString("title"));
			return book;
		}
	}

}

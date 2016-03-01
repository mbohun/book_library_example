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

@Repository
public class LentBooksDaoImpl implements LentBooksDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<String> findByCustomerId(int customerId) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		String sql =
			"SELECT title FROM books b, lent_books p WHERE p.customer_id=" + customerId + " and b.isbn = p.isbn_id";
 
		List<String> result = namedParameterJdbcTemplate.query(sql, params, new BookTitleMapper());
        return result;
	}

	private static final class BookTitleMapper implements RowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("title");
		}
	}

}

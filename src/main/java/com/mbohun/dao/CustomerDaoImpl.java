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

import com.mbohun.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Customer> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM customers";

		List<Customer> result = namedParameterJdbcTemplate.query(sql, params, new CustomerMapper());
        return result;
	}

	private static final class CustomerMapper implements RowMapper<Customer> {
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setName(rs.getString("name"));
			customer.setPhone(rs.getString("phone"));
			customer.setEmail(rs.getString("email"));
			return customer;
		}
	}

}

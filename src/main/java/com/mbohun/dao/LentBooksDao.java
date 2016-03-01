package com.mbohun.dao;

import java.util.List;

public interface LentBooksDao {
	List<String> findByCustomerId(int customerId);
}

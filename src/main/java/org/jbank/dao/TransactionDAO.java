package org.jbank.dao;

import java.util.List;

import org.jbank.model.Transaction;

public interface TransactionDAO {

	void save(Transaction transaction);
	
	List<Transaction> findAll();
	
}

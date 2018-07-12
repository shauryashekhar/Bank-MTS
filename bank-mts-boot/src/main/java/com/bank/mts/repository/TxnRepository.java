package com.bank.mts.repository;

import java.util.List;

import com.bank.mts.model.Txn;

public interface TxnRepository {
	void save(Txn txn);

	List<Txn> findAll();
}
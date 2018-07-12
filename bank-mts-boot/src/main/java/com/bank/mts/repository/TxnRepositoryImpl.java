package com.bank.mts.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bank.mts.model.Txn;

@Repository
public class TxnRepositoryImpl implements TxnRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Txn txn) {
		entityManager.persist(txn);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Txn> findAll() {
		return entityManager.createQuery("from Txn").getResultList();
	}

}
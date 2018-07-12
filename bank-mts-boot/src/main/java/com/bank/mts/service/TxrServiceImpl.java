package com.bank.mts.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bank.mts.model.Account;
import com.bank.mts.model.Txn;
import com.bank.mts.model.TxnType;
import com.bank.mts.repository.AccountRepository;
import com.bank.mts.repository.TxnRepository;

@Component
public class TxrServiceImpl implements TxrService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TxnRepository txnRepository;

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void setTxnRepopository(TxnRepository txnRepopository) {
		this.txnRepository = txnRepopository;
	}

	@Transactional
	public void txr(double amount, String fromAccNum, String toAccNum) {
		try {

			Account fromAccount = accountRepository.load(fromAccNum);
			Account toAccount = accountRepository.load(toAccNum);

			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);

			fromAccount = accountRepository.update(fromAccount);
			boolean b = false;
			if (b)
				throw new RuntimeException();
			toAccount = accountRepository.update(toAccount);

			Txn debitTxn = new Txn();
			debitTxn.setAmount(amount);
			debitTxn.setType(TxnType.DEBIT);
			debitTxn.setDate(new Date());
			debitTxn.setClosingBalance(fromAccount.getBalance());
			debitTxn.setAccount(fromAccount);

			Txn creditTxn = new Txn();
			creditTxn.setAmount(amount);
			creditTxn.setType(TxnType.CREDIT);
			creditTxn.setDate(new Date());
			creditTxn.setClosingBalance(toAccount.getBalance());
			creditTxn.setAccount(toAccount);

			txnRepository.save(debitTxn);
			txnRepository.save(creditTxn);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}

package com.bank.mts.service;

import com.bank.mts.repository.AccountRepository;
import com.bank.mts.repository.TxnRepository;

public interface TxrService {
	public void setAccountRepository(AccountRepository accountRepository);
	public void setTxnRepopository(TxnRepository txnRepopository);
	void txr(double amount, String fromAccNum, String toAccNum);
}

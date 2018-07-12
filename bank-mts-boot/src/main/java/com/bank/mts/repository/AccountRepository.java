package com.bank.mts.repository;

import com.bank.mts.model.Account;

public interface AccountRepository {

	Account load(String num);

	Account update(Account account);

}
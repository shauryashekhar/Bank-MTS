package com.bank.mts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.mts.model.Account;
import com.bank.mts.model.Txn;
import com.bank.mts.repository.TxnRepositoryImpl;
import com.bank.mts.service.TxrService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/txr")
public class TxrController {

	@Autowired
	private TxrService txrService;

	@Autowired
	private TxnRepositoryImpl txrRepo;
	
	@Autowired
	private TxrResponse txrResponse;

	@SuppressWarnings("finally")
	@PostMapping
	public String doPost(@RequestBody TxnForm form) {
		// Account account = new Account();
		// account.setNum(accountId);
		//
		// Txn txn = new Txn();
		// txn.setAccount(account);
		double amount = form.getAmount();
		String fromAccNum = form.getFromAccNum();
		String toAccNum = form.getToAccNum();
		txrResponse.setMessage("Transaction Complete....");
		try {
			txrService.txr(amount, fromAccNum, toAccNum);
		} catch (Exception e) {
			txrResponse.setMessage(e.getMessage() + " Transaction not Completed!...");
		} finally {
			return txrResponse.getMessage();
		}
	}
	
	@GetMapping
	public List<Txn> getAll() {
		return txrRepo.findAll();
	}

}

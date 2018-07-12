package com.bank.mts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bank.mts.repository.AccountRepository;
import com.bank.mts.repository.TxnRepository;
import com.bank.mts.service.TxrService;

@SpringBootApplication
@EnableAutoConfiguration
public class BankMtsBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankMtsBootApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(AccountRepository accountRepository, TxnRepository txnRepository, TxrService txrService) {
		return args -> {
			// System.out.println(accountRepository.load("1"));
			txrService.txr(200, "1", "2");
			System.out.println(txnRepository.findAll());
			
		};
	}
}

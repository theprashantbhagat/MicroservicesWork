package com.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyexchange.beans.CurrencyExchange;
import com.currencyexchange.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeRepository repository;
	
	
	@Autowired
	Environment environment;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveCurency(@PathVariable String from ,@PathVariable String to)
	{
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnv(port);
		return currencyExchange;
	}
}

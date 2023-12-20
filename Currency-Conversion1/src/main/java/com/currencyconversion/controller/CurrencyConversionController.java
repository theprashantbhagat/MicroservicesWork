package com.currencyconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currencyconversion.beans.CurrenyConversion;
import com.currencyconversion.client.CurrencyConversionClient;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyConversionClient client;
	
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenyConversion calculateCurrenyConversion(@PathVariable String from ,@PathVariable String to,@PathVariable BigDecimal quantity)
	{
		HashMap<String, String> uriVariable= new HashMap<>();
		
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		ResponseEntity<CurrenyConversion> forEntity = new RestTemplate().getForEntity("http://localhost:8686/currency-exchange/from/{from}/to/{to}",CurrenyConversion.class, uriVariable);
		
		CurrenyConversion conversion = forEntity.getBody();
		
		CurrenyConversion newconversion= new CurrenyConversion(
				conversion.getId(),
				from,
				to,
				quantity, 
				conversion.getConversionMultiple(),
				quantity.multiply(conversion.getConversionMultiple()),
				conversion.getEnv());
		return newconversion;
		
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenyConversion calConversion(@PathVariable String from ,@PathVariable String to ,@PathVariable BigDecimal quantity)
	{
		
		
		CurrenyConversion conversion = client.retirConversion(from, to);
		
		
		
		CurrenyConversion finalsConversion= new CurrenyConversion
				(conversion.getId(), 
				from,
				to,
				quantity, 
				conversion.getConversionMultiple(),
				quantity.multiply(conversion.getConversionMultiple()),
				conversion.getEnv());
		
		
		
		return finalsConversion;
		
	}
	
	}


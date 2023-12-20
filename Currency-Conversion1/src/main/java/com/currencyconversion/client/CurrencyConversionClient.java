package com.currencyconversion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currencyconversion.beans.CurrenyConversion;

//@FeignClient(name = "currency-exchage",url = "localhost:8686" )
@FeignClient(name ="currency-exchange")
public interface CurrencyConversionClient {

	
	@GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
	public CurrenyConversion retirConversion(@PathVariable String from , @PathVariable String to);
	
	
	
	
}

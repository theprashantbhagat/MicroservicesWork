package com.currencyexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currencyexchange.beans.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	public CurrencyExchange findByFromAndTo(String from, String to);

}

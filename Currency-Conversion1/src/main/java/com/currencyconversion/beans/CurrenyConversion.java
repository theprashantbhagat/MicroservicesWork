package com.currencyconversion.beans;

import java.math.BigDecimal;

public class CurrenyConversion {

	private Long id;

	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal conversionMultiple;
	private BigDecimal totalConversion;
	private String env;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getTotalConversion() {
		return totalConversion;
	}
	public void setTotalConversion(BigDecimal totalConversion) {
		this.totalConversion = totalConversion;
	}
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}
	@Override
	public String toString() {
		return "CurrenyConversion [id=" + id + ", from=" + from + ", to=" + to + ", quantity=" + quantity
				+ ", conversionMultiple=" + conversionMultiple + ", totalConversion=" + totalConversion + ", env=" + env
				+ "]";
	}
	public CurrenyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
			BigDecimal totalConversion, String env) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionMultiple = conversionMultiple;
		this.totalConversion = totalConversion;
		this.env = env;
	}
	public CurrenyConversion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}

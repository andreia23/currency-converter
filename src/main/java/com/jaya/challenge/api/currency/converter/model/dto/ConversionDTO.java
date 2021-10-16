package com.jaya.challenge.api.currency.converter.model.dto;

import com.jaya.challenge.api.currency.converter.model.entity.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author andreia
 *
 */
public class ConversionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idTransaction;
	
	private User idUser;

    private String sourceCurrency;

    private BigDecimal sourceValue;

    private String destinationCurrency;
    
    private BigDecimal destinationValue;

    private double conversionRate;

    private Instant date = Instant.now();

	public Integer getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public String getSourceCurrency() {
		return sourceCurrency;
	}

	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	public BigDecimal getSourceValue() {
		return sourceValue;
	}

	public void setSourceValue(BigDecimal sourceValue) {
		this.sourceValue = sourceValue;
	}

	public String getDestinationCurrency() {
		return destinationCurrency;
	}

	public void setDestinationCurrency(String destinationCurrency) {
		this.destinationCurrency = destinationCurrency;
	}

	public BigDecimal getDestinationValue() {
		return destinationValue;
	}

	public void setDestinationValue(BigDecimal destinationValue) {
		this.destinationValue = destinationValue;
	}

	public double getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}
    
    

}

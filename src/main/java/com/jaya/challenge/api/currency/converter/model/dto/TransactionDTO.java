package com.jaya.challenge.api.currency.converter.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import com.jaya.challenge.api.currency.converter.model.entity.User;

/**
 * @author andreia
 *
 */
public class TransactionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User idUser;

	private String sourceCurrency;

	private BigDecimal sourceValue;

	private String destinationCurrency;

	private double conversionRate;

	private Instant date = Instant.now();

	/**
	 * @return the idUser
	 */
	public User getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the sourceCurrency
	 */
	public String getSourceCurrency() {
		return sourceCurrency;
	}

	/**
	 * @param sourceCurrency the sourceCurrency to set
	 */
	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	/**
	 * @return the sourceValue
	 */
	public BigDecimal getSourceValue() {
		return sourceValue;
	}

	/**
	 * @param sourceValue the sourceValue to set
	 */
	public void setSourceValue(BigDecimal sourceValue) {
		this.sourceValue = sourceValue;
	}

	/**
	 * @return the destinationCurrency
	 */
	public String getDestinationCurrency() {
		return destinationCurrency;
	}

	/**
	 * @param destinationCurrency the destinationCurrency to set
	 */
	public void setDestinationCurrency(String destinationCurrency) {
		this.destinationCurrency = destinationCurrency;
	}

	/**
	 * @return the conversionRate
	 */
	public double getConversionRate() {
		return conversionRate;
	}

	/**
	 * @param conversionRate the conversionRate to set
	 */
	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}

	/**
	 * @return the date
	 */
	public Instant getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Instant date) {
		this.date = date;
	}

}

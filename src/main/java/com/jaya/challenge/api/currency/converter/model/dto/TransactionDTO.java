package com.jaya.challenge.api.currency.converter.model.dto;

import com.jaya.challenge.api.currency.converter.model.entity.Transaction;
import com.jaya.challenge.api.currency.converter.model.request.Currency;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author andreia
 *
 */
public class TransactionDTO {

	private Long idTransaction;

	private Long idUser;

	private Currency sourceCurrency;

	private BigDecimal sourceValue;

	private Currency destinationCurrency;

	private BigDecimal conversionRate;

	private Instant date = Instant.now();

	public TransactionDTO(Transaction transaction) {
		this.idTransaction = transaction.getIdTransaction();
		this.idUser = transaction.getUser().getIdUser();
		this.sourceCurrency = transaction.getSourceCurrency();
		this.sourceValue = transaction.getSourceValue();
		this.destinationCurrency = transaction.getDestinationCurrency();
		this.conversionRate = transaction.getConversionRate();
	}

	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}

	/**
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the sourceCurrency
	 */
	public Currency getSourceCurrency() {
		return sourceCurrency;
	}

	/**
	 * @param sourceCurrency the sourceCurrency to set
	 */
	public void setSourceCurrency(Currency sourceCurrency) {
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
	public Currency getDestinationCurrency() {
		return destinationCurrency;
	}

	/**
	 * @param destinationCurrency the destinationCurrency to set
	 */
	public void setDestinationCurrency(Currency destinationCurrency) {
		this.destinationCurrency = destinationCurrency;
	}

	/**
	 * @return the conversionRate
	 */
	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	/**
	 * @param conversionRate the conversionRate to set
	 */
	public void setConversionRate(BigDecimal conversionRate) {
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

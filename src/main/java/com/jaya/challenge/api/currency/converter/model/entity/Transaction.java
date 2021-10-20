package com.jaya.challenge.api.currency.converter.model.entity;

import com.jaya.challenge.api.currency.converter.model.request.Currency;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.*;

/**
 * @author andreia
 */
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;

    @ManyToOne
    private User user;

    private Currency sourceCurrency;

    private BigDecimal sourceValue;

    private Currency destinationCurrency;

    private BigDecimal conversionRate;

    private Instant date = Instant.now();

    public Transaction(User user, Currency sourceCurrency, BigDecimal sourceValue, Currency destinationCurrency,
                       BigDecimal conversionRate) {

        this.user = user;
        this.sourceCurrency = sourceCurrency;
        this.sourceValue = sourceValue;
        this.destinationCurrency = destinationCurrency;
        this.conversionRate = conversionRate;
    }

    public Transaction() {

    }

    /**
     * @return the idTransaction
     */
    public Long getIdTransaction() {
        return idTransaction;
    }

    /**
     * @param idTransaction the idTransaction to set
     */
    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    /**
     * @return the idUser
     */
    public User getUser() {
        return user;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setUser(User idUser) {
        this.user = idUser;
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

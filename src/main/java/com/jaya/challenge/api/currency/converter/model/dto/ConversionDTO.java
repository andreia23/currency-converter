package com.jaya.challenge.api.currency.converter.model.dto;

import com.jaya.challenge.api.currency.converter.model.request.Currency;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author andreia
 */
public class ConversionDTO {

    private Long idTransaction;

    private Long idUser;

    private Currency sourceCurrency;

    private BigDecimal sourceValue;

    private Currency destinationCurrency;

    private BigDecimal destinationValue;

    private BigDecimal conversionRate;

    private Instant date = Instant.now();

    public ConversionDTO(Long idTransaction, Long idUser, Currency sourceCurrency, BigDecimal sourceValue, Currency destinationCurrency, BigDecimal destinationValue, BigDecimal conversionRate) {
        this.idTransaction = idTransaction;
        this.idUser = idUser;
        this.sourceCurrency = sourceCurrency;
        this.sourceValue = sourceValue;
        this.destinationCurrency = destinationCurrency;
        this.destinationValue = destinationValue;
        this.conversionRate = conversionRate;
    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public BigDecimal getSourceValue() {
        return sourceValue;
    }

    public Currency getDestinationCurrency() {
        return destinationCurrency;
    }

    public BigDecimal getDestinationValue() {
        return destinationValue;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public Instant getDate() {
        return date;
    }
}

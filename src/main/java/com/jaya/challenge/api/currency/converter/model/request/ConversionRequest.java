package com.jaya.challenge.api.currency.converter.model.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

/**
 * @author andreia
 */
public class ConversionRequest {

    @NotNull(message = "Source currency cannot be null")
    private Currency sourceCurrency;

    @NotNull(message = "Source value cannot be null")
    private BigDecimal sourceValue;

    @NotNull(message = "Destination currency cannot be null")
    private Currency destinationCurrency;

    public ConversionRequest(Currency sourceCurrency, BigDecimal sourceValue, Currency destinationCurrency) {
        this.sourceCurrency = sourceCurrency;
        this.sourceValue = sourceValue;
        this.destinationCurrency = destinationCurrency;
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


}

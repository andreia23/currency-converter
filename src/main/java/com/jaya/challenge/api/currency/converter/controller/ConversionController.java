package com.jaya.challenge.api.currency.converter.controller;

import javax.validation.Valid;

import com.jaya.challenge.api.currency.converter.exception.ConverterAPIExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaya.challenge.api.currency.converter.model.dto.ConversionDTO;
import com.jaya.challenge.api.currency.converter.model.request.ConversionRequest;
import com.jaya.challenge.api.currency.converter.service.ConversionService;

/**
 * @author andreia
 *
 */
@RestController
public class ConversionController {

	private ConversionService conversionService;

	private Logger logger = LoggerFactory.getLogger(ConversionController.class);

	@Autowired
	public ConversionController(ConversionService conversionService) {
		this.conversionService = conversionService;
	}

	@PostMapping(value = "/v1/currency-converter")
	public ConversionDTO convertCurrency(@Valid @RequestBody ConversionRequest r,
			@RequestParam Long idUser) {
		logger.info("User " + idUser + " converting " + r.getSourceCurrency() + " to " + r.getDestinationCurrency() );
		return conversionService.convertCurrency(idUser, r);

	}

}

package com.jaya.challenge.api.currency.converter.controller;

import javax.validation.Valid;

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

	@Autowired
	public ConversionController(ConversionService conversionService) {
		this.conversionService = conversionService;
	}

	@PostMapping(value = "/v1/currency-converter")
	public ConversionDTO convertCurrency(@Valid @RequestBody ConversionRequest conversionRequest,
			@RequestParam Long idUser) {
		return conversionService.convertCurrency(idUser, conversionRequest);

	}

}

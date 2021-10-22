package com.jaya.challenge.api.currency.converter.exception;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andreia
 */

@ControllerAdvice
@RestController
public class ConverterAPIExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	private Logger logger = LoggerFactory.getLogger(ConverterAPIExceptionHandler.class);

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDetails handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		StringBuilder message = new StringBuilder();
		List<FieldError> fieldErrorList = ex.getBindingResult().getFieldErrors();
		for (FieldError error : fieldErrorList) {
			message.append(messageSource.getMessage(error, LocaleContextHolder.getLocale())).append("; ");
		}
		String messageError = message.toString(); 
		logger.error(messageError);
		return new ErrorDetails(new Date(), message.toString(), HttpStatus.BAD_REQUEST.value());
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = UserNotFoundException.class)
	public ErrorDetails handleNotFoundException(UserNotFoundException ex) {
		logger.error(ex.getMessage());
		return new ErrorDetails(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.value());
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = CurrencyNotSupportedException.class)
	public ErrorDetails handleCurrencyNotSupportedException(CurrencyNotSupportedException ex) {
		logger.error(ex.getMessage());
		return new ErrorDetails(new Date(), ex.getMessage(), HttpStatus.BAD_REQUEST.value());
	}

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public ErrorDetails handleGenericException(Exception ex) {
		logger.error(ex.getMessage());
		return new ErrorDetails(new Date(), ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
}

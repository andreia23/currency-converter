package com.jaya.challenge.api.currency.converter.exception;

import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author andreia
 *
 */

@ControllerAdvice
@RestController
public class ConverterAPIExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation failed", ex.getBindingResult().toString());

		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(value = NotEnoughMoneyException.class)
//	public final ResponseEntity<ErrorDetails> handleNotEnoughMoneyException(NotEnoughMoneyException ex,
//			WebRequest request) {
//
//		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
//
//		return new ResponseEntity<>(errorDetails, HttpStatus.GONE);
//	}

	@ExceptionHandler(value = AccountNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleNotFoundException(AccountNotFoundException ex, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleNotFoundException(UserNotFoundException ex, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidDataException.class)
	public final ResponseEntity<ErrorDetails> handleDataInvalidException(InvalidDataException ex, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(value = DuplicateDataException.class)
//	public final ResponseEntity<ErrorDetails> handleDataDuplicateException(DuplicateDataException ex,
//			WebRequest request) {
//
//		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
//
//		return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
//	}

	@ExceptionHandler(value = { ServerErrorException.class })
	protected ResponseEntity<ErrorDetails> handleAPIException(ServerErrorException ex, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

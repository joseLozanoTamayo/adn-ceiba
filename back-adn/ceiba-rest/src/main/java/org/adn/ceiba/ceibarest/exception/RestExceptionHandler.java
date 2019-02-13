package org.adn.ceiba.ceibarest.exception;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class RestExceptionHandler.
 *
 * @version 1.0
 * @since 1.0
 */
@ControllerAdvice

/** The Constant log. */
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	/** The message source. */
	@Autowired
	public MessageSource messageSource;
	
	/** The Constant SEPARATOR. */
	public static final String SEPARATOR = ".";
	
	/** The Constant VALIDATOR_ERROR. */
	private static final String  VALIDATOR_ERROR = "VALIDATOR ERROR";
	
	/** The Constant INVALID_ARGUMENTS. */
	private static final String INVALID_ARGUMENTS = "Argumentos no validos";
	
	/** The Constant FIND_NOT_FOUND. */
	private static final String FIND_NOT_FOUND = "Recurso no encontrado";
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException exception,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {		
				
		final DetailError detailError = new DetailError();
		detailError.setTitle(FIND_NOT_FOUND);
		detailError.setTimeStamp(Calendar.getInstance().getTimeInMillis());
		detailError.setStatus(status.value());
		detailError.setDetail(exception.getMessage());
		detailError.setDeveloperMessage(exception.getClass().getName());				
					
		return handleExceptionInternal(exception , detailError , headers , status , request);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
				
		final DetailError detailError = new DetailError();
		detailError.setTitle(INVALID_ARGUMENTS);
		detailError.setTimeStamp(Calendar.getInstance().getTimeInMillis());
		detailError.setStatus(status.value());
		detailError.setDetail(VALIDATOR_ERROR);
		log.info("{} : {}", VALIDATOR_ERROR, exception.getMessage());
		detailError.setDeveloperMessage(exception.getClass().getName());	
		
		// Create ValidationError instances
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(fe -> {
			
			List<ValidationError> validationErrorList = detailError.getErrors().get(fe.getField());			
			if (Objects.isNull(validationErrorList)) {				
				validationErrorList = new ArrayList<ValidationError>();
				detailError.getErrors().put(fe.getField(), validationErrorList);
			}
			ValidationError validationError = new ValidationError();
			validationError.setCode(fe.getCode());
			validationError.setMessage(fe.getDefaultMessage());
			validationErrorList.add(validationError);
		});	
		
		return handleExceptionInternal(exception , detailError , headers , status , request);
	}	
}

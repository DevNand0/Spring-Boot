package net.javaguides.sb_test.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
//clase que ejecuta todas las exceptiones generadas por errores del controlador
	
	//exception para los elementos no encontrados
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(details, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> handleAPIException(APIException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(details, HttpStatus.NOT_FOUND);
	}
	
	//excepciones globales
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?>handleGlobalException(Exception exception,WebRequest request){
		ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//excepcion de validacion personalizada
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationErroHanding(MethodArgumentNotValidException exception){
		ErrorDetails details= new ErrorDetails(new Date(), "Validation Error", 
				                               exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity(details, HttpStatus.BAD_REQUEST);
	}
	

}

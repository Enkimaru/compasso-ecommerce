package br.com.compasso.productapi.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.compasso.productapi.exceptions.models.ErrorModel;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST, "Erro de validação", ex.getBindingResult().toString());

            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        @Override
        protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST, "Erro de validação", ex.getMessage());

            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        
        
	    @ExceptionHandler(EntityNotFoundException.class)
	    private ResponseEntity<ErrorModel> handleEntityNotFound(EntityNotFoundException ex){
	        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, "Produto não encontrado", ex.getMessage());
	
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }
	
}

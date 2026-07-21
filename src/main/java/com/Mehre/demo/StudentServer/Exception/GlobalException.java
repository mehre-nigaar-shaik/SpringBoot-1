package com.Mehre.demo.StudentServer.Exception;

import com.Mehre.demo.StudentServer.DTO.ExceptionResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    // Handle Runtime Exceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDTO> handleRuntimeException(RuntimeException e, HttpServletRequest req) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage(), req.getRequestURI());
        return ResponseEntity
                .status(500)
                .body(exceptionResponseDTO);
    }

    // Handle Illegal Argument Exceptions
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    // Handle Validation Exceptions (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException e) {

        String error = e.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    // Handle All Remaining Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong.");
    }
}
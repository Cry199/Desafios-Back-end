package com.picpaydesafiobackend.infra;

import com.picpaydesafiobackend.dtos.ExceptionDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler
{
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException e)
    {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Duplicate entry", "400");

        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException e)
    {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralException(Exception e)
    {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "500");

        return ResponseEntity.internalServerError().body(exceptionDTO);
    }
}

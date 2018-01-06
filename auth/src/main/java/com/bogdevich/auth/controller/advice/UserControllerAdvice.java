package com.bogdevich.auth.controller.advice;

import com.bogdevich.auth.controller.UserController;
import com.bogdevich.auth.controller.exception.NotFoundException;
import com.bogdevich.auth.entity.dto.ExceptionMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice(basePackageClasses = UserController.class)
public class UserControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionMessageDTO> handleNotFoundException(Throwable ex){
        ExceptionMessageDTO messageDTO = new ExceptionMessageDTO();
        messageDTO.setTime(LocalDateTime.now().toString());
        messageDTO.setStatus(HttpStatus.NOT_FOUND.value());
        messageDTO.setMessage(ex.getMessage());
        return new ResponseEntity<>(messageDTO, HttpStatus.NOT_FOUND);
    }
}
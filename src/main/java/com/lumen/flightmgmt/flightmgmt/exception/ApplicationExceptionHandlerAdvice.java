package com.lumen.flightmgmt.flightmgmt.exception;
import org.hibernate.PropertyValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandlerAdvice {

    private final Logger logger;
    public ApplicationExceptionHandlerAdvice() {
        logger= LoggerFactory.getLogger(this.getClass().getName());
    }
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException e){
        logger.warn(e.getMessage());
        return ResponseEntity.status(404).body(Map.of("error",e.getMessage()));
    }
    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<?> handlePropertyValueException(PropertyValueException e){
        logger.warn(e.getMessage());
        return ResponseEntity.status(404).body(Map.of("error",e.getMessage()));
    }
    @ExceptionHandler(InvalidEmailFormat.class)
    public ResponseEntity<?> handleInvalidEmailFormat(InvalidEmailFormat e){
        logger.warn(e.getMessage());
        return ResponseEntity.status(404).body(Map.of("error",e.getMessage()));
    }
    @ExceptionHandler(InvalidPhoneNumberFormat.class)
    public ResponseEntity<?> handleInvalidPhoneNumberFormat(InvalidPhoneNumberFormat e){
        logger.warn(e.getMessage());
        return ResponseEntity.status(404).body(Map.of("error",e.getMessage()));
    }

}

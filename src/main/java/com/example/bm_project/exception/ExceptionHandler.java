package com.example.bm_project.exception;
import com.example.bm_project.enums.ErrorCodeEnum;
import com.example.bm_project.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.example.bm_project.constant.StringConstants.FailedMessage;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundCurrencyCodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ResponseEntity<ErrorResponse> handleCurrencyNotFoundException(){
        ErrorResponse errorResponse=new ErrorResponse(FailedMessage,"currency00#%**", ErrorCodeEnum.CurrencyNotFound.getValue());
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ResponseEntity<ErrorResponse> handleInvalidArgumentException(){
        ErrorResponse errorResponse=new ErrorResponse(FailedMessage,"amount#2$$",ErrorCodeEnum.InValidAmount.getValue());
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(GlobalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ResponseEntity<ErrorResponse> handleGlobalException(){
        ErrorResponse errorResponse=new ErrorResponse(FailedMessage,"invalid&%44**",ErrorCodeEnum.GlobalExceptionError.getValue());
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}

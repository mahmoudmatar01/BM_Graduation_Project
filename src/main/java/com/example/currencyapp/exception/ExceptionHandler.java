package com.example.currencyapp.exception;
import com.example.currencyapp.enums.ErrorCodeEnum;
import com.example.currencyapp.logger.Logger;
import com.example.currencyapp.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.example.currencyapp.constant.StringConstants.FailedMessage;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    private Logger logger ;
    public ExceptionHandler() {
        this.logger =logger.getInstance();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundCurrencyCodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ResponseEntity<ErrorResponse> handleCurrencyNotFoundException(){
        ErrorResponse errorResponse=new ErrorResponse(FailedMessage,"currency00#%**", ErrorCodeEnum.CurrencyNotFound.getValue());
        logger.logInfo(this.getClass(),"handleCurrencyNotFoundException worked successfully");
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ResponseEntity<ErrorResponse> handleInvalidArgumentException(){
        ErrorResponse errorResponse=new ErrorResponse(FailedMessage,"amount#2$$",ErrorCodeEnum.InValidAmount.getValue());
        logger.logInfo(this.getClass(),"handleInvalidArgumentException worked successfully");
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(GlobalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ResponseEntity<ErrorResponse> handleGlobalException(){
        ErrorResponse errorResponse=new ErrorResponse(FailedMessage,"invalid&%44**",ErrorCodeEnum.GlobalExceptionError.getValue());
        logger.logInfo(this.getClass(),"handleGlobalException worked successfully");
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}

package cn.jtoss.springbootresponse.response;

import cn.jtoss.springbootresponse.exception.BaseException;
import cn.jtoss.springbootresponse.exception.BizCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

/**
 * @author jason
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * 抓取全局异常（保底）
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultResponse<String> exception(Exception e) {
        log.error("全局异常信息: {}", e.getMessage(), e);
        return ResultResponse.createFailureResponse(BizCode.SYSTEM_ERROR.code, e.getMessage(), null);
    }

//    @ExceptionHandler(AuthenticationException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ResultResponse<String> exception(AuthenticationException e) {
//        log.error("Spring Security 认证异常信息: {}", e.getMessage(), e);
//        return ResultResponse.createFailureResponse(HttpStatus.UNAUTHORIZED.value(), e.getMessage(), null);
//    }

    /**
     * Assert异常
     */
    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultResponse<String> exception(IllegalArgumentException e) {
        return ResultResponse.createFailureResponse(BizCode.ILLEGAL_ARGUMENT.code, e.getMessage(), null);
    }


    /**
     * 抓取自定义异常
     */
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultResponse<String> exception(BaseException e) {
        return ResultResponse.createFailureResponse(e.getErrorCode(), e.getMessage(), null);
    }

    /**
     * 抓取validation校验异常
     */
    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ResultResponse<String>> handleValidatedException(Exception e) {
        ResultResponse<String> response = null;

        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            String message = ex.getBindingResult().getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("; "));
            response = ResultResponse.createFailureResponse(HttpStatus.BAD_REQUEST.value(), message, null);
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException ex = (ConstraintViolationException) e;
            String message = ex.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("; "));
            response = ResultResponse.createFailureResponse(HttpStatus.BAD_REQUEST.value(), message, null);
        } else if (e instanceof BindException) {
            BindException ex = (BindException) e;
            String message = ex.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("; "));
            response = ResultResponse.createFailureResponse(HttpStatus.BAD_REQUEST.value(), message, null);
        }

        log.error("参数校验异常:{}", response.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

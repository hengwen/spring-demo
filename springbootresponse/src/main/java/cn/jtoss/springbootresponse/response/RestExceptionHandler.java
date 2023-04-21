package cn.jtoss.springbootresponse.response;

import cn.jtoss.springbootresponse.exception.BaseException;
import cn.jtoss.springbootresponse.exception.BizCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


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

    /**
     * 抓取自定义异常
     */
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultResponse<String> exception(BaseException e) {
        return ResultResponse.createFailureResponse(e.getErrorCode(), e.getMessage(), null);
    }
}

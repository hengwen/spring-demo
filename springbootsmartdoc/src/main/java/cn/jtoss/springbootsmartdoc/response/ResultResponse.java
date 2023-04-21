package cn.jtoss.springbootsmartdoc.response;


import cn.jtoss.springbootsmartdoc.exception.BizCode;
import cn.jtoss.springbootsmartdoc.exception.BizException;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 统一返回格式
 *
 * @author jason
 */
public class ResultResponse<T> implements Serializable {

    /**
     * 状态码
     */
    @Getter
    @Setter
    private Integer code;

    /**
     * 消息
     */
    @Getter
    @Setter
    private String message;

    /**
     * 数据
     */
    @Getter
    @Setter
    private T data;

    /**
     * 时间戳
     */
    @Getter
    @Setter
    private long timestamp;

    public ResultResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功代码
     */
    private static final int SUCCESS_CODE = 200;
    /**
     * 默认成功消息
     */
    public static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    /**
     * 默认错误消息
     */
    public static final String DEFAULT_ERROR_MESSAGE = "UNKNOWN ERROR";

    public static <T> ResultResponse<T> createFailureResponse(int code, String msg, T data) {
        return new ResultResponse<T>().genError(code, msg, data);
    }

    public static <T> ResultResponse<T> createSuccessResponse(T data) {
        return new ResultResponse<T>().genSuccess(data);
    }

    public static <T> ResultResponse<T> createFailureResponse(BizException bizException) {
        return new ResultResponse<T>().genError(bizException);
    }

    public static <T> ResultResponse<T> createFailureResponse(BizCode bizCode) {
        return new ResultResponse<T>().genError(bizCode);
    }

    public static <T> ResultResponse<T> createFailureResponse(BizCode bizCode, T data) {
        return new ResultResponse<T>().genError(bizCode, data);
    }

    public ResultResponse<T> genSuccess(T data) {
        code = SUCCESS_CODE;
        message = DEFAULT_SUCCESS_MESSAGE;
        this.data = data;
        return this;
    }

    public ResultResponse<T> genError(int code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
        return this;
    }

    public ResultResponse<T> genError(BizException ex) {
        code = ex.getErrorCode();
        message = ex.getMessage();
        data = null;
        return this;
    }

    public ResultResponse<T> genError(BizCode bizCode) {
        code = bizCode.code;
        message = bizCode.message;
        data = null;
        return this;
    }

    public ResultResponse<T> genError(BizCode bizCode, T data) {
        code = bizCode.code;
        message = bizCode.message;
        this.data = data;
        return this;
    }
}

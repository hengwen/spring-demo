package cn.jtoss.springbootvalidation.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jason
 */
public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = -5099085051827483520L;

    @Getter
    @Setter
    private int errorCode;

    public BaseException(String errorMessage) {
        super(errorMessage);
    }

    public BaseException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public BaseException(String errorMessage, Throwable e) {
        super(errorMessage, e);
    }

    public BaseException(int errorCode, String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.errorCode = errorCode;
    }
}

package cn.jtoss.springbootswagger.exception;

/**
 * @author jason
 */
public enum BizCode {
    /**服务异常**/
    BAD_REQUEST(400, "参数错误"),
    SYSTEM_ERROR(500,"系统异常，请稍后重试"),
    INVALID_TOKEN(2001,"访问令牌不合法"),
    ACCESS_DENIED(2003,"没有权限访问该资源"),
    ILLEGAL_ARGUMENT(3001,"非法参数");

    public final Integer code;
    public final String message;

    BizCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

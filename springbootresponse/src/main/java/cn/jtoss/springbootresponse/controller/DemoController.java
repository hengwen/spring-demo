package cn.jtoss.springbootresponse.controller;

import cn.jtoss.springbootresponse.exception.BizCode;
import cn.jtoss.springbootresponse.exception.BizException;
import cn.jtoss.springbootresponse.response.ResultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jason
 */
@RestController
public class DemoController {
    @GetMapping("/success")
    public ResultResponse<String> success() {
        return ResultResponse.createSuccessResponse("hello!");
    }

    @GetMapping("/exception")
    public ResultResponse<String> exception() {
        return ResultResponse.createFailureResponse(BizCode.ACCESS_DENIED);
    }

    @GetMapping("/exception2")
    public ResultResponse<String> exception2() {
        try {
            return ResultResponse.createSuccessResponse(mockServiceMethod());
        } catch (BizException e) {
            return ResultResponse.createFailureResponse(e);
        }
    }

    @GetMapping("/successElegant")
    public String successElegant() {
        return "Elegant";
    }

    @GetMapping("/error")
    public int error() {
        int i = 1/0;
        return i;
    }

    @GetMapping("/exception3")
    public String exception3() {
        return mockServiceMethod();
    }

    private String mockServiceMethod() {
        throw new BizException(BizCode.ACCESS_DENIED.code, BizCode.ACCESS_DENIED.message);
    }
}

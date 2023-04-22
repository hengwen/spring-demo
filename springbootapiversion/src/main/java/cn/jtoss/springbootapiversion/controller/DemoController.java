package cn.jtoss.springbootapiversion.controller;

import cn.jtoss.springbootapiversion.annotation.ApiVersion;
import cn.jtoss.springbootapiversion.domain.ValidVO;
import cn.jtoss.springbootapiversion.validator.ValidGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jason
 */
@Slf4j
@RestController
@Validated
@Api(tags = "接口版本控制")
public class DemoController {
    /**
     * 通过URL Path实现版本控制
     */
    @GetMapping("/api/v1/user")
    public String getUser1(){
        return "api version: v1";
    }

    /**
     * 通过QueryString中的version参数实现版本控制
     */
    @GetMapping(value = "/api/user", params = "version=2")
    public String getUser2(@RequestParam("version") int version) {
        return "api version: v2";
    }

    /**
     * 通过请求头中的X-API-VERSION参数实现版本控制
     */
    @GetMapping(value = "/api/user", headers = "X-API-VERSION=3")
    public String getUser3(@RequestHeader("X-API-VERSION") int version) {
        return "api version: v3";
    }

    /**
     * 通过请求头中的媒体类型Accept Header实现版本控制
     */
    @GetMapping(value="/api/user", produces = "application/api-v4+json")
    public String getUser4() {
        return "api version: v4";
    }

    @ApiVersion("5")
    @GetMapping(value="/api/{v}/user")
    public String getUser5() {
        return "api version: v5";
    }

    @ApiVersion("6.0.1")
    @GetMapping(value="/api/{v}/user")
    public String getUser6() {
        return "api version: v6.0.1";
    }
}

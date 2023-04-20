package cn.jtoss.sprintboothotdeploy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jason
 */
@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo() {
        String message = "hello world122";
        return message;
    }
}

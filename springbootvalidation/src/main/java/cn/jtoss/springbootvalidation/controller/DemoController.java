package cn.jtoss.springbootvalidation.controller;

import cn.jtoss.springbootvalidation.domain.ValidVO;
import cn.jtoss.springbootvalidation.validator.ValidGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import java.util.Date;

/**
 * @author jason
 */
@Slf4j
@RestController
@Validated
public class DemoController {
    @PostMapping("/valid/test1")
    public String test1(@Validated @RequestBody ValidVO validVO){
        log.info("validEntity is {}", validVO);
        return "test1 valid success";
    }

    @PostMapping(value = "/valid/test2")
    public String test2(@Validated ValidVO validVO){
        log.info("validEntity is {}", validVO);
        return "test2 valid success";
    }

    @PostMapping(value = "/valid/test3")
    public String test3(@Email String email){
        log.info("email is {}", email);
        return "email valid success";
    }

    @PostMapping(value = "/valid/add")
    public String add(@Validated(value = ValidGroup.Crud.Create.class) ValidVO validVO){
        log.info("validEntity is {}", validVO);
        return "test3 valid success";
    }

    @PostMapping(value = "/valid/update")
    public String update(@Validated(value = ValidGroup.Crud.Update.class) ValidVO validVO){
        log.info("validEntity is {}", validVO);
        return "test4 valid success";
    }

    @GetMapping("testDate")
    public Date processApi(Date date) {
        return date;
    }
}

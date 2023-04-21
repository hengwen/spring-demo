package cn.jtoss.springbootswagger.controller;

import cn.jtoss.springbootswagger.domain.ValidVO;
import cn.jtoss.springbootswagger.validator.ValidGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jason
 */
@Slf4j
@RestController
@Validated
@Api(tags = "参数校验")
public class DemoController {
    @ApiOperation("添加接口")
    @PostMapping(value = "/valid/add")
    public String add(@Validated(value = ValidGroup.Crud.Create.class) @RequestBody ValidVO validVO){
        log.info("validEntity is {}", validVO);
        return "test3 valid success";
    }

    @ApiOperation("更新接口")
    @PostMapping(value = "/valid/update")
    public String update(@Validated(value = ValidGroup.Crud.Update.class) @RequestBody ValidVO validVO){
        log.info("validEntity is {}", validVO);
        return "test4 valid success";
    }
}

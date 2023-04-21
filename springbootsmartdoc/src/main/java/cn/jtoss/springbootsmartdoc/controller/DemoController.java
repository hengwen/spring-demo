package cn.jtoss.springbootsmartdoc.controller;

import cn.jtoss.springbootsmartdoc.domain.ValidVO;
import cn.jtoss.springbootsmartdoc.validator.ValidGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Smart-doc Demo Controller
 * @author jason
 */
@Slf4j
@RestController
@Validated
public class DemoController {
    /**
     * 添加
     *
     * @param validVO 有效签证官
     * @return {@link String}
     */
    @PostMapping(value = "/valid/add")
    public String add(@Validated(value = ValidGroup.Crud.Create.class) @RequestBody ValidVO validVO){
        log.info("validEntity is {}", validVO);
        return "test3 valid success";
    }

    /**
     * 更新
     *
     * @param validVO 有效签证官
     * @return {@link String}
     */
    @PostMapping(value = "/valid/update")
    public String update(@Validated(value = ValidGroup.Crud.Update.class) @RequestBody ValidVO validVO){
        log.info("validEntity is {}", validVO);
        return "test4 valid success";
    }
}

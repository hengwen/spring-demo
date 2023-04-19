package cn.jtoss.springbootlogback.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author jason
 */
@RestController
@Slf4j
public class DemoController {
    @GetMapping("/demo")
    public void demo() {
        log.trace("trace log @ {}", LocalDateTime.now());
        log.debug("debug log @ {}", LocalDateTime.now());
        log.info("info log @ {}", LocalDateTime.now());
        log.warn("warn log @ {}", LocalDateTime.now());
        log.error("error log @ {}", LocalDateTime.now());
    }
}

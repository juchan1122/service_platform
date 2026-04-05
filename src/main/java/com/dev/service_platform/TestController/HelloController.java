package com.dev.service_platform.TestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/test")
    public String test() {
        return "스프링 부트 서버가 정상적으로 연결되었습니다! - 주찬";
    }

    @GetMapping("/")
    public String home() {
        return "여기는 메인 페이지입니다.";
    }
}

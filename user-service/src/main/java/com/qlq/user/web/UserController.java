package com.qlq.user.web;

import com.qlq.user.config.PatternProperties;
import com.qlq.user.pojo.User;
import com.qlq.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatternProperties properties;

//    /**
//     * 注入nacos中的配置属性
//     */
//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @GetMapping("/prop")
    public PatternProperties properties() {
        return properties;
    }

    /**
     * 通过日期格式化工具返回格式化的时间测试nacos的配置属性
     * @return
     */
    @GetMapping("/now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Truth", required = false) String truth) {
        System.out.println("truth: " + truth);
        return userService.queryById(id);
    }
}

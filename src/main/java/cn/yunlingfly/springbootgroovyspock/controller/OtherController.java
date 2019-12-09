package cn.yunlingfly.springbootgroovyspock.controller;

import cn.yunlingfly.springbootgroovyspock.bean.Other;
import cn.yunlingfly.springbootgroovyspock.service.IOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunlingfly
 * @date 2019/12/9
 */
@RestController
public class OtherController {
    @Autowired
    IOtherService iOtherService;

    @RequestMapping(value = "/other")
    public Other getOtherById(Integer id) {
        return iOtherService.getOtherById(id);
    }
}

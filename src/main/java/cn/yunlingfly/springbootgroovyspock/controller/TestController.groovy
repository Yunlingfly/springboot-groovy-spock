package cn.yunlingfly.springbootgroovyspock.controller

import cn.yunlingfly.springbootgroovyspock.bean.Cc
import cn.yunlingfly.springbootgroovyspock.bean.Other
import cn.yunlingfly.springbootgroovyspock.service.IOtherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author yunlingfly
 * @date 2019/12/9
 */
@RestController
class TestController {
    @Autowired
    IOtherService iOtherService

    @RequestMapping(value = "/hello")
    Cc hello() {
        Cc cc = new Cc()
        cc.name = "myName"
        cc.version = "0.1"
        return cc
    }

    @RequestMapping(value = "/getOtherById")
    Other getOtherById(Integer id) {
        return iOtherService.getOtherById(id)
    }
}

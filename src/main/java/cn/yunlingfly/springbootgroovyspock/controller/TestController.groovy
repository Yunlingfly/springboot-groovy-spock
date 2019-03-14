package cn.yunlingfly.springbootgroovyspock.controller

import cn.yunlingfly.springbootgroovyspock.bean.Cc
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @RequestMapping(value = "/hello")
    Cc hello(){
        Cc cc=new Cc()
        cc.name="myName"
        cc.version="0.1"
        return cc
    }
}

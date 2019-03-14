package cn.yunlingfly.springbootgroovyspock.controller

import cn.yunlingfly.springbootgroovyspock.bean.Cc
import com.alibaba.fastjson.JSON
import org.junit.Assert
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

// 使用Spock测试框架框架就不能使用下面的注解否则报错No runnable methods
//@RunWith(SpringRunner.class)
// 如果不RANDOM_PORT的话TestRestTemplate注入时会异常NoSuchBeanDefinitionException
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestControllerTests extends Specification{
    @Autowired
    private TestRestTemplate testRestTemplate

    void '测试/hello'() {
        given: '定义请求数据格式'
        def searchParam = ""

        when: '向接口发请求'
        Cc context = testRestTemplate.getForObject("/hello",Cc.class);

        then: '状态码为200'
        println(JSON.toJSONString(context))
        Assert.assertEquals('myName', context.name)

//        Cc context = testRestTemplate.getForObject("/hello",Cc.class);
//        println(JSON.toJSONString(context))
//        Assert.assertEquals('myName', context.name)
    }
}

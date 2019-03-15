package cn.yunlingfly.springbootgroovyspock.controller

import cn.yunlingfly.springbootgroovyspock.bean.Cc
import cn.yunlingfly.springbootgroovyspock.bean.Other
import cn.yunlingfly.springbootgroovyspock.service.IOtherService
import com.alibaba.fastjson.JSON
import org.junit.Assert
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Shared
import spock.lang.Specification

// 使用Spock测试框架框架就不能使用下面的注解否则报错No runnable methods
//@RunWith(SpringRunner.class)
// 如果不RANDOM_PORT的话TestRestTemplate注入时会异常NoSuchBeanDefinitionException
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestControllerTests extends Specification{
    @Autowired
    private TestRestTemplate testRestTemplate

    TestController testController=new TestController()
    @Autowired
    IOtherService otherService;

    @Shared
    def Other other

    void setup() {
        otherService=Mock(IOtherService)
        testController.iOtherService=otherService
    }

    def '测试/hello'() {
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

    def '测试/getOtherById'() {
        // given 定义数据
        given: '定义请求数据格式'
        // 初始化我们测试接口返回的数据
        other = new Other()
        other.setId(1)
        other.setName("myName")
        other.setEnabled(true)

        // and 准备数据
        and:'mock'
        otherService.getOtherById(_) >> other

        // when 待测试的函数
        when: '向接口发请求'
        Other other1 = testController.getOtherById(a)

        // then 判断是否符合预期
        then: '状态码为200'
        println(JSON.toJSONString(other1))
//        Assert.assertEquals('myName', other1.name)
        other1.name==c

        // where 反复调用
        where:
        a|c
        1|'name'
        2|'myName'
    }
}

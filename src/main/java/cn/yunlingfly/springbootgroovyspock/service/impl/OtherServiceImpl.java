package cn.yunlingfly.springbootgroovyspock.service.impl;

import cn.yunlingfly.springbootgroovyspock.bean.Other;
import cn.yunlingfly.springbootgroovyspock.service.IOtherService;
import org.springframework.stereotype.Service;

@Service
public class OtherServiceImpl implements IOtherService {
    public Other getOtherById(Integer id){
        Other other=new Other();
        other.setId(id);
        other.setName("test");
        other.setEnabled(true);
        return other;
    }
}

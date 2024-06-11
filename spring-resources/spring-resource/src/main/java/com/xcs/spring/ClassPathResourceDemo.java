package com.xcs.spring;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author xcs
 * @date 2023年10月30日 11时04分
 **/
public class ClassPathResourceDemo {
    public static void main(String[] args) throws Exception {
        String path = "application.properties";
        Resource resource = new ClassPathResource(path);
        InputStreamUtil.getInputStream(resource);
    }
}

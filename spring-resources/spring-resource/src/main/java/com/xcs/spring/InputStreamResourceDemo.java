package com.xcs.spring;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author xcs
 * @date 2023年10月30日 11时30分
 **/
public class InputStreamResourceDemo {
    public static void main(String[] args) throws Exception {
        InputStream isSource = new ByteArrayInputStream("hello world3".getBytes());
        Resource resource = new InputStreamResource(isSource);
        InputStreamUtil.getInputStream(resource);
    }
}

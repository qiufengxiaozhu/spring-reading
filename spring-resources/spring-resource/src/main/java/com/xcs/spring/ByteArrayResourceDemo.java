package com.xcs.spring;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

/**
 * @author xcs
 * @date 2023年10月30日 11时29分
 **/
public class ByteArrayResourceDemo {
    public static void main(String[] args) throws Exception {
        byte[] data = "hello world".getBytes();
        Resource resource = new ByteArrayResource(data);
        InputStreamUtil.getInputStream(resource);
    }
}

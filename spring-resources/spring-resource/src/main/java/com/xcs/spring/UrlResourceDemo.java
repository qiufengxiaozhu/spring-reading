package com.xcs.spring;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

/**
 * @author xcs
 * @date 2023年10月30日 11时17分
 **/
public class UrlResourceDemo {
    public static void main(String[] args) throws Exception {
        Resource resource = new UrlResource("https://dist.apache.org/repos/dist/test/test.txt");
        InputStreamUtil.getInputStream(resource);
    }
}

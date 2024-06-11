package com.xcs.spring;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * @author xcs
 * @date 2023年10月30日 11时11分
 **/
public class FileSystemResourceDemo {
    public static void main(String[] args) throws Exception {
        // 请替换你自己的目录
        String path = "E:\\GitHubProject\\spring-reading\\spring-resources\\spring-resource\\src\\main\\resources\\myfile.txt";
        Resource resource = new FileSystemResource(path);
        InputStreamUtil.getInputStream(resource);
    }
}

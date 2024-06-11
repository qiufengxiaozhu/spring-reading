package com.xcs.spring;

import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputStreamUtil {

	/**
	 * 两种方式各有优缺点：
	 * 逐字节读取（已注释部分）：
	 * 优点：适用于任何类型的数据文件，包括二进制文件。
	 * 缺点：需要手动管理缓冲区（byte[]数组），代码相对复杂；且在处理文本文件时，需手动处理字符编码问题。
	 * 逐行读取（当前使用部分）：
	 * 优点：代码更简洁、易读，特别适合处理文本文件；通过BufferedReader和readLine()自动处理了换行符，且可以直接指定字符编码（如StandardCharsets.UTF_8），避免了字符编码问题。
	 * 缺点：不适合直接用于处理二进制文件，因为readLine()方法假设以行结束符分割，可能不适用于所有类型的二进制数据。
	 * 综上，如果处理的是文本文件，尤其是需要按行处理逻辑时，当前使用的逐行读取方式更好。而对于二进制文件或需要更细粒度控制读取过程的情况，逐字节读取可能更合适。
	 * @param resource 资源
	 */
	public static void getInputStream(Resource resource) throws IOException {
		try (InputStream is = resource.getInputStream()) {
			// 读取和处理资源内容
			StringBuilder sb = new StringBuilder();

			byte[] bytes = new byte[1024];
			int len;
			while ((len = is.read(bytes)) != -1) {
				sb.append(new String(bytes, 0, len));
			}

			System.out.println(sb);
		}

		try (InputStream is = resource.getInputStream();
		     BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append(System.lineSeparator());
			}
			System.out.println(sb);
		}

		// 对于ByteArrayResource这样的内存资源，不需要显式关闭，只需要管理那些需要关闭的资源即可，如文件流、网络流等。
		// 对于内存中的简单资源包装器，通常不需要在代码中进行关闭操作。
		// 所以resource.getInputStream()内容可以重复读取
	}
}

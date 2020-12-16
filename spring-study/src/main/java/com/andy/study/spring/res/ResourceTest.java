package com.andy.study.spring.res;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * @time: 2020/11/24 十一月 11:42
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@Slf4j
public class ResourceTest {

    @Test
    public void test() throws Exception {
        UrlResource urlResource = new UrlResource("https://editor.csdn.net/md/?articleId=83304148");
        boolean exists = urlResource.exists();
        InputStream inputStream = urlResource.getInputStream();
        byte[] bytes = new byte[1024];
        int n = 0;

        OutputStream os = new ByteArrayOutputStream();
        while ((n = inputStream.read(bytes)) != -1) {
            os.write(bytes, 0, n);
        }
        log.debug("url 是否存在:{}", exists);
        log.debug("os 是否存在:{}", os.toString());
    }

    @Test
    public void test02() throws Exception {
        Resource urlResource = new ClassPathResource("bean03.xml");

        InputStream inputStream = urlResource.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String s = null;
        while ((s = br.readLine()) != null) {
            sb.append(s).append("\n");
        }

        log.debug("输出:{}", sb);

    }

    @Test
    public void test03() throws Exception {
        Resource urlResource = new FileSystemResource("/Users/xiangdan/IdeaProjects/javastudy/spring-study/src/main/resources/bean02.xml");

        InputStream inputStream = urlResource.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String s = null;
        while ((s = br.readLine()) != null) {
            sb.append(s).append("\n");
        }

        log.debug("输出:{}", sb);
    }

    private String resourceToString(Resource resource) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(resource.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String s = null;
            while ((s = br.readLine()) != null) {
                sb.append(s).append("\n");
            }
            log.debug("输出 resource:{}", resource);
            log.debug("输出 内容:{}", sb);
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test04() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Resource[] resources = resolver.getResources("classpath*:/META-INF/spring.*");
        log.debug("总共找到:{}", resources.length);

        for (Resource resource : resources) {
            resourceToString(resource);
        }

    }
}

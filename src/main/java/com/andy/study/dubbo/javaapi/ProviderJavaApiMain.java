package com.andy.study.dubbo.javaapi;

import com.andy.study.dubbo.javaapi.impl.HelloServiceJavaApiImpl;
import com.andy.study.dubbo.xml.service.HelloService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.util.concurrent.CountDownLatch;

/**
 * @time: 2020/11/6 十一月 20:20
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ProviderJavaApiMain {

    public static void main(String[] args) throws InterruptedException {
        HelloService helloService = new HelloServiceJavaApiImpl();
        // 当前应用配置
        ApplicationConfig app = new ApplicationConfig();
        String s = app.toString();
        System.out.println(s);
        app.setQosEnable(false);
        app.setQosPort(22223);
        app.setName("JavaApiprovider");
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://localhost");
        registry.setPort(2181);

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20882);
        protocol.setThreads(200);
        // 服务提供者暴露服务配置
        ServiceConfig<HelloService> service = new ServiceConfig<HelloService>();
        service.setApplication(app);
        service.setProtocol(protocol);
        service.setRegistry(registry);
        service.setInterface(HelloService.class);
        service.setRef(helloService);
        service.setVersion("1.0.0");

        service.export();

        new CountDownLatch(1).await();

    }



}

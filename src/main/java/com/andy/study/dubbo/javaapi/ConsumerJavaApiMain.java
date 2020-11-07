package com.andy.study.dubbo.javaapi;

import com.andy.study.dubbo.xml.service.HelloService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.EchoService;

/**
 * @time: 2020/11/6 十一月 20:20
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class ConsumerJavaApiMain {
    public static void main(String[] args) {
        // 当前应用配置
        ApplicationConfig app = new ApplicationConfig();
        app.setQosEnable(false);
        app.setName("JavaApiconsumer");
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://localhost");
        registry.setPort(2181);
        registry.setProtocol("zoookeeper");

        ReferenceConfig<HelloService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setRegistry(registry);
        referenceConfig.setApplication(app);
        referenceConfig.setInterface("com.andy.study.dubbo.xml.service.HelloService");
        referenceConfig.setVersion("1.0.0");
        //referenceConfig.setScope("remote");
        referenceConfig.setUrl("dubbo://localhost:20880/com.andy.study.dubbo.xml.service.HelloService");
        RpcContext context = RpcContext.getContext();
        RpcContext serverContext = RpcContext.getServerContext();

        System.out.println(context  );
        System.out.println(serverContext  );
        HelloService service = referenceConfig.get();
        context = RpcContext.getContext();
        serverContext = RpcContext.getServerContext();
        String s2 = service.sayHello("xby");

        System.out.println(context.isConsumerSide()  );
        System.out.println(context.isProviderSide()  );
        System.out.println(serverContext  );
        EchoService es = (EchoService) service;
        for (int i =0;i<10;i++){
            String s = service.sayHello("xby");
            Object ok = es.$echo("ok");
            System.out.println(s+"  "+ok);
        }

    }
}

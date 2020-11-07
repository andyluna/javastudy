package com.andy.study.dubbo.spi;

import org.apache.dubbo.common.extension.ExtensionFactory;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.extension.LoadingStrategy;
import org.apache.dubbo.rpc.Protocol;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

import static java.util.ServiceLoader.load;
import static java.util.stream.StreamSupport.stream;

/**
 * @time: 2020/11/7 十一月 11:16
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class SpiTest {

    @Test
    public void test1(){

        ServiceLoader<LoadingStrategy> loader = ServiceLoader.load(LoadingStrategy.class);
        Iterator<LoadingStrategy> iterator = loader.iterator();

        while(iterator.hasNext()){
            LoadingStrategy next = iterator.next();

            System.out.println(next);

        }


        LoadingStrategy[] array = StreamSupport.stream(load(LoadingStrategy.class).spliterator(), false)
                .sorted()
                .toArray(LoadingStrategy[]::new);

        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2(){
        ExtensionLoader<ExtensionFactory> loader1 = ExtensionLoader.getExtensionLoader(ExtensionFactory.class);
        ExtensionFactory factory = loader1.getAdaptiveExtension();
        System.out.println(factory);
        ExtensionLoader<Protocol> loader = ExtensionLoader.getExtensionLoader(Protocol.class);


        Protocol protocol = loader.getAdaptiveExtension();

        Protocol dubbo = loader.getExtension("dubbo");
        System.out.println(protocol);
        System.out.println(dubbo);

    }

}

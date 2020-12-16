package com.andy.study.springmvc.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.util.ReflectionUtils;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @time: 2020/12/1 十二月 13:04
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@HandlesTypes(MyServerletInitializer.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
    private static final Logger log = LoggerFactory.getLogger(MyServletContainerInitializer.class);

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        log.debug("我的自定义初始化器启动了");
        ctx.log("我的自定义初始化器启动了");

        List<MyServerletInitializer> initializers = Collections.emptyList();

        if (c != null) {
            initializers = new ArrayList<>(c.size());
            for (Class<?> waiClass : c) {
                if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
                        MyServerletInitializer.class.isAssignableFrom(waiClass)) {
                    try {
                        initializers.add((MyServerletInitializer)
                                ReflectionUtils.accessibleConstructor(waiClass).newInstance());
                    } catch (Throwable ex) {
                        throw new ServletException("Failed to instantiate WebApplicationInitializer class", ex);
                    }
                }
            }
        }

        if (initializers.isEmpty()) {
            ctx.log("No MyServerletInitializer types detected on classpath");
            return;
        }

        ctx.log(initializers.size() + " Spring WebApplicationInitializers detected on classpath");
        AnnotationAwareOrderComparator.sort(initializers);
        for (MyServerletInitializer initializer : initializers) {
            initializer.onStartup(ctx);
        }

    }
}

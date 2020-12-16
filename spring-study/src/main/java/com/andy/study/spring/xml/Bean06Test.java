package com.andy.study.spring.xml;

import com.andy.study.spring.xml.ext.MyClasspathXmlApplicationContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.DocumentLoader;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.xml.SimpleSaxErrorHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

/**
 * @time: 2020/11/20 十一月 13:50
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Bean06Test {
    private static Logger logger = LoggerFactory.getLogger(Bean06Test.class);

    public static void main(String[] args) {

        MyClasspathXmlApplicationContext context = new MyClasspathXmlApplicationContext("bean06.xml");
        logger.info("启动完成 总共有 {} 个bean", context.getBeanDefinitionCount());
        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            Object bean = context.getBean(names[i]);
            logger.info("{}.{} {} = {}", i + 1, names[i], bean.getClass(), bean);
        }


        context.registerShutdownHook();

    }

    @Test
    public void test1() throws Exception {
        Log logger2 = LogFactory.getLog(Bean06Test.class);
        DefaultResourceLoader dl = new DefaultResourceLoader();
        Resource resource = dl.getResource("bean06.xml");
        System.out.println(resource.exists());
        InputSource inputSource = new InputSource(resource.getInputStream());
        EntityResolver entityResolver = new ResourceEntityResolver(dl);
        ErrorHandler errorHandler = new SimpleSaxErrorHandler(logger2);
        int validationMode = 3;
        boolean namespaceAware = false;

        DocumentLoader documentLoader = new DefaultDocumentLoader();
        Document document = documentLoader.loadDocument(inputSource, entityResolver,
                errorHandler, validationMode, namespaceAware);

        Element element = document.getDocumentElement();

        NodeList nodes = element.getChildNodes();

        System.out.println(document.getClass() + " = " + nodes.getLength());
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            if (item instanceof Element) {
                System.out.print("属于element");
                System.out.println(item.getNodeName() + "  " + item.getClass());
                NamedNodeMap attributes = item.getAttributes();
                System.out.println("attributes = " + attributes);
                System.out.println("attributes = " + item.getNodeType());
                for (int j = 0; j < attributes.getLength(); j++) {
                    Node namedItem = attributes.item(j);

                    System.out.println(namedItem.getNodeName() + "=" + namedItem.getNodeValue());
                }
            } else {
                //System.out.print ("不属于element");
            }

        }

    }
}

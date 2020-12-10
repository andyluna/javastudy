package com.andy.study.embed.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

/**
 * @time: 2020/12/6 十二月 17:00
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTomcat01Test {
    public static int TOMCAT_PORT = 8080;
    public static String TOMCAT_HOSTNAME = "localhost";
    public static String WEBAPP_PATH = "src/main";
    public static String WEBINF_CLASSES = "/WEB-INF/classes";
    public static String CLASS_PATH = "target/classes";
    public static String INTERNAL_PATH = "/";
    public static final String DEFAULT_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";


    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setHostname(TOMCAT_HOSTNAME);
        tomcat.setBaseDir("/Users/xiangdan/IdeaProjects/javastudy/tomcat-base");
//        Connector connector = new Connector(DEFAULT_PROTOCOL);
//        connector.setThrowOnFailure(true);
//        tomcat.getService().addConnector(connector);
//        tomcat.setConnector(connector);
//        tomcat.getHost().setAutoDeploy(false);


        tomcat.start();
    }
}

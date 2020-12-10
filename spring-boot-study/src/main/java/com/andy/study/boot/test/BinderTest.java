package com.andy.study.boot.test;

import org.springframework.boot.context.properties.bind.BindContext;
import org.springframework.boot.context.properties.bind.BindHandler;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

import javax.xml.transform.Source;

/**
 * @time: 2020/12/4 十二月 22:44
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class BinderTest {


    public static void main(String[] args) {
        System.setProperty("spring.xiangdan.id", "2");
        System.setProperty("spring.xiangdan.username", "向丹");

        Environment env = new StandardEnvironment();

        System.out.println(env);
        System.out.println(env.getProperty("id"));
        System.out.println(env.getProperty("username"));

        Binder binder = Binder.get(env);

        A a = new A();
        System.out.println(a);

        Bindable<A> instance = Bindable.ofInstance(a);
        System.out.println(instance);
        BindResult<A> id = binder.bind("spring.xiangdan", instance, new BindHandler() {
            @Override
            public <T> Bindable<T> onStart(ConfigurationPropertyName name, Bindable<T> target, BindContext context) {
                System.out.println("绑定开始"+name);
                return target;
            }

            @Override
            public Object onSuccess(ConfigurationPropertyName name, Bindable<?> target, BindContext context, Object result) {
                System.out.println("绑定成功"+name);
                return result;
            }

            @Override
            public Object onCreate(ConfigurationPropertyName name, Bindable<?> target, BindContext context, Object result) {
                System.out.println("绑定onCreate"+name);
                return result;
            }

            @Override
            public Object onFailure(ConfigurationPropertyName name, Bindable<?> target, BindContext context, Exception error) throws Exception {
                System.out.println("绑定onFailure"+name+"  异常日志:"+error.getMessage());
                return null;
            }

            @Override
            public void onFinish(ConfigurationPropertyName name, Bindable<?> target, BindContext context, Object result) throws Exception {
                System.out.println("绑定onFinish"+name);
                System.out.println("结果:"+result);
            }
        });

        System.out.println(a);
    }

    public static class A{
        private String id;
        private Integer age;
        private String username;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "A{" +
                    "id='" + id + '\'' +
                    ", age=" + age +
                    ", username='" + username + '\'' +
                    '}';
        }
    }

}

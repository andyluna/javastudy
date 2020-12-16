package com.andy.study.spring.spel;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @time: 2020/11/24 十一月 20:52
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class SpelTest {
    @Test
    public void test01() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        log.debug("message={}", message);
    }

    @Test
    public void test02() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        log.debug("message={}", message);
    }

    @Test
    public void test03() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        log.debug("message={}", bytes.length);
    }

    @Test
    public void test04() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();
        log.debug("message={}", length);
    }

    @Test
    public void test05() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        log.debug("message={}", message);
    }

    @Test
    public void test06() {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");
        String name = (String) exp.getValue(tesla);
        log.debug("name={}", name);
        exp = parser.parseExpression("name == 'Nikola Tesla'");
        boolean result = exp.getValue(tesla, Boolean.class);
        log.debug("result={}", result);
    }

    @Test
    public void test07() {
        Simple simple = new Simple();
        simple.booleanList.add(true);
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("booleanList[0]").setValue(context, simple, "false");
        Boolean b = simple.booleanList.get(0);
        log.debug("result={}", b);

    }

    @Test
    public void test09() {
        //1.准备表达式
        String express1 = "Hello,测试用户:${user1}  --- ${deptName} --- ${userName} --- ${userId}  -->系统属性:${user.home}";
        //2.准备参数
        //2.1准备map参数
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("user1", "赵聪");
        paraMap.put("deptName", "组织部");
        paraMap.put("userName", "zhaocong");
        paraMap.put("userId", "MyUserId");

        MutablePropertySources propertySources = new MutablePropertySources();
        propertySources.addLast(new MapPropertySource("param1", paraMap));
        //2.2放入系统参数
        propertySources.addLast(new PropertiesPropertySource("param2", System.getProperties()));

        //3.创建解析器
        PropertySourcesPropertyResolver psp = new PropertySourcesPropertyResolver(propertySources);
        //4.解析
        String res1 = psp.resolvePlaceholders(express1);
        System.out.println(res1);
    }

    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

class Simple {
    public List<Boolean> booleanList = new ArrayList<Boolean>();
}

class Inventor {
    private String name;
    private Date birthday;
    private String nationality;

    public Inventor(String name, Date birthday, String nationality) {
        this.name = name;
        this.birthday = birthday;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
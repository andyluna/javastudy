package com.andy.study.spring.circular;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @time: 2020/11/20 十一月 21:58
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class C1 {
    private List<String> list;
    private Set<String> set;
    private Map<String,Float> map;
    private Properties properties;

    private String name1;
    private String name2;

    private D1 d1 = new D1();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, Float> getMap() {
        return map;
    }

    public void setMap(Map<String, Float> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public D1 getD1() {
        return d1;
    }

    public void setD1(D1 d1) {
        this.d1 = d1;
    }

    @Override
    public String toString() {
        return "C1{" +
                "list=" + list +
                ", listClass=" + (list!=null?list.getClass():null) +
                ", set=" + set +
                ", listClass=" + (set!=null?set.getClass():null) +
                ", map=" + map +
                ", mapClass=" + (map!=null?map.getClass():null) +
                ", properties=" + properties +
                ", propertiesClass=" + (properties!=null?properties.getClass():null) +
                ", name1=" + name1 +
                ", name2=" + name2 +
                ", d1=" + d1 +
                '}';
    }
}

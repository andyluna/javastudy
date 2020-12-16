package com.andy.study.spring.spel;

/**
 * @time: 2020/11/24 十一月 21:18
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MySpel {
    private String name;

    private Integer age;

    private String username;

    private Double random;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getRandom() {
        return random;
    }

    public void setRandom(Double random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "MySpel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", random=" + random +
                '}';
    }
}

<%@ page import="com.liyi.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/5/21
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person=new Person();
        List<String> cities=new ArrayList<String>();
        Map<String,Object> map = new HashMap<>();

        person.setName("大哥");
        person.setPhone(new String[]{"19991216","75445545","499987897"});
        cities.add("北京");
        cities.add("上海");
        cities.add("长沙");
        person.setCities(cities);
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);

        pageContext.setAttribute("p",person);
    %>

    输出整个Person：${p}</br>
    输出Person的name属性：${p.name}</br>
    输出Person的phone数组下标为0的属性值：${p.phone[0]}</br>
    输出Person的cities集合中全部的元素值：${p.cities}</br>
    输出Person的cities集合中个别的元素值：${p.cities[1]}</br>
    输出Person的整个map集合：${p.map}</br>
    输出Person的map集合中某个key的值：${p.map.key1}</br>

    输出Person的age属性对应的get方法：${p.age}</br>





</body>
</html>

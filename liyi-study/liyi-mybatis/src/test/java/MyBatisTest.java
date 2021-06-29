import com.study.liyi.mybatis.bean.Employee;
import com.study.liyi.mybatis.dao.EmployeeMapper;
import com.study.liyi.mybatis.dao.EmployeeMapperAnnotation;
import com.study.liyi.mybatis.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/28 20:50  星期一
 */
public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

        return  sqlSessionFactory;
    }


    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            Employee employee=sqlSession.selectOne("selectEmp",1);
            System.out.println(employee);
        }finally {
            //5.关闭 sqlSession
            sqlSession.close();
        }
    }

    /**
     * 接口式 EmployeeMapper.xml相当于是EmployeeMapper的实现,实际上是mybatis会为接口生成一个代理对象(将接口和xml进行绑定)
     * SqlSession代表和数据库的一次会话,用完必须关闭
     * SqlSession和connection一样,都是非线程安全的,每次使用都应该去获取新的对象
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            //获取接口的实现类对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            //会为接口自动创建一个代理对象,代理对象去执行增删改查
            System.out.println(mapper);//org.apache.ibatis.binding.MapperProxy@4fcd19b3

            Employee emp = mapper.getEmpById(1);
            System.out.println(emp);
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            //获取接口的实现类对象
            EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);

            Employee emp = mapper.getEmpById(1);
            System.out.println(emp);
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 测试增删改
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        //获取到的SqlSession不会自动提交
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            //获取接口的实现类对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);


            //添加  修改
            Employee employee = new Employee(null, "Jerry2", "0", "45544545454@qq.com");
            boolean b = mapper.addEmp(employee);
            System.out.println(employee.getId());
            System.out.println(b);
            //mapper.updateEmp(employee);
            //mapper.deleteEmpById(2);   //删除

            //手动提交
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void test5() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        //获取到的SqlSession不会自动提交
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            //获取接口的实现类对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            Employee emp = mapper.getEmpByIdAndLastName(1,"Jerry");
//            System.out.println(emp);

            List<Employee> emps = mapper.getEmpsByLastNameList("%Jerry%");
            for(Employee employee:emps){
                System.out.println(employee);
            }
            //手动提交
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void test6() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        //获取到的SqlSession不会自动提交
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            Map<String, Object> empMap = mapper.getEmpByIdReturnMap(3);
//            System.out.println(empMap);
            Map<Integer, Employee> empsByIdReturnMap = mapper.getEmpsByIdReturnMap("%Jerry%");
            System.out.println(empsByIdReturnMap);

        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void test7() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        //获取到的SqlSession不会自动提交
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
//            Employee empById = mapper.getEmpById(3);
//            System.out.println(empById);

            Employee empAndDept = mapper.getEmpAndDept(1);
            System.out.println(empAndDept);
            System.out.println(empAndDept.getDept());

        }finally {
            sqlSession.close();
        }
    }





}

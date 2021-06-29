import com.study.liyi.mybatis.bean.Employee;
import com.study.liyi.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/28 20:50  星期一
 */
public class MyBatisTest {

    public SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return  sqlSession;
    }


    @Test
    public void test1() throws IOException {
        SqlSession sqlSession=getSqlSession();
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
        SqlSession sqlSession=getSqlSession();
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



}

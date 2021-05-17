import com.liyi.pojo.User;
import com.liyi.service.UserService;
import com.liyi.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/17 17:01  星期一
 */
public class UserServiceTest {

    UserService userService=new UserServiceImpl();

    @Test
    public void registUser(){
        userService.registUser(new User(null,"bbj1","6666","666@qq.com"));
//        userService.registUser(new User(null,"admin","123","666@qq.com"));

    }

    @Test
    public void login(){
        System.out.println(userService.login(new User(null,"admin","123",null)));


    }

    @Test
    public void existUsername(){
        if (userService.existsUsername("admin")){
            System.out.println("用户名已存在!");
        }else {
            System.out.println("用户名可用!");
        }

    }

}

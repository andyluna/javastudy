package com.liyi.spring.spring5.jvm.service;

import com.liyi.spring.spring5.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/4 22:33  星期日
 */
@Service
@Transactional
public class AccountService {

    //注入Dao
    @Autowired
    private AccountDao accountDao;

    //转账
    public void accountMoney(){
//        try {
            //开启事务

            //Lucy少100
            accountDao.reduceMoney();
            //模拟异常
            int i=10/0;
            //Mary多100
            accountDao.addMoney();
            //没有异常 提交事务
//        }catch (Exception e){
//            e.printStackTrace();
            //出现异常 事务回滚

//        }
    }
}

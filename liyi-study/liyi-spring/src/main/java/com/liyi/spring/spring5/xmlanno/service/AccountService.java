package com.liyi.spring.spring5.xmlanno.service;

import com.liyi.spring.spring5.xmlanno.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/5 16:20  星期一
 */
@Service
//@Transactional  //添加事务
public class AccountService {
    //注入Dao
    @Autowired
    private AccountDao accountDao;

    public void accountMoney(){
        accountDao.reduceMoney();

        //模拟异常
        int i=10/0;

        accountDao.addMoney();
    }
}

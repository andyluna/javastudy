package com.liyi.study.study001.project03.junit;

import com.liyi.study.study001.project03.domain.Employee;
import com.liyi.study.study001.project03.service.NameListService;
import com.liyi.study.study001.project03.service.TeamException;
import org.junit.Test;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/20 17:25  星期二
 */
public class NameListServiceTest {

    @Test
    public void testGetAllEmployees(){

        NameListService service=new NameListService();
        Employee[] employees=service.getAllEmployees();
        for (int i=0;i< employees.length;i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service=new NameListService();
        int id=1;
        id=101;
        try {
            Employee employee=service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

}

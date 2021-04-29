package com.liyi.study.base.project03.service;

import com.liyi.study.base.project03.domain.Architect;
import com.liyi.study.base.project03.domain.Designer;
import com.liyi.study.base.project03.domain.Employee;
import com.liyi.study.base.project03.domain.Equipment;
import com.liyi.study.base.project03.domain.NoteBook;
import com.liyi.study.base.project03.domain.PC;
import com.liyi.study.base.project03.domain.Printer;
import com.liyi.study.base.project03.domain.Programmer;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/20 10:51  星期二
 */
public class NameListService {

    private Employee[] employees;

    /**
     * 给数组employees及数组元素进行初始化
     */
    public NameListService(){
//        1.根据项目提供的Data类构建相应大小的employees数组
        employees=new Employee[Data.EMPLOYEES.length];
//        2.再根据Data类中的数据构建不同的对象
        for (int i=0;i<employees.length;i++){
            //获取员工的类型
            int type=Integer.parseInt(Data.EMPLOYEES[i][0]);

            //获取Employee的4个基本信息
            int id=Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name=Data.EMPLOYEES[i][2];
            int age=Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary=Double.parseDouble(Data.EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;

            switch (type){
                case Data.EMPLOYEE:
                    employees[i]=new Employee(id,name,age,salary);
                    break;

                case Data.PROGRAMMER:
                    equipment=createEquipment(i);
                    employees[i]=new Programmer(id,name,age,salary,equipment);
                    break;

                case Data.DESIGNER:
                    equipment=createEquipment(i);
                    bonus=Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i]=new Designer(id,name,age,salary,equipment,bonus);
                    break;

                case Data.ARCHITECT:

                    equipment=createEquipment(i);
                    bonus=Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock=Integer.parseInt(Data.EMPLOYEES[i][6]);
                    // 3.将对象存在数组中
                    employees[i]=new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }




    }

    //获取指定index位置员工的设备
    private Equipment createEquipment(int index) {
        int key=Integer.parseInt(Data.EQUIPMENTS[index][0]);
        String model=Data.EQUIPMENTS[index][1];

        switch (key){
            case Data.PC://21
                return new PC(model,Data.EQUIPMENTS[index][2]);

            case Data.NOTEBOOK://22
                double price=Double.parseDouble(Data.EQUIPMENTS[index][2]);
                return new NoteBook(model,price);
            case Data.PRINTER://23
                String type=Data.EQUIPMENTS[index][2];
                return new Printer(model,type);
        }
        return null;
    }

    public Employee[] getAllEmployees(){
        return employees;
    }

    /**
     * 获取指定id的员工
     * @param id
     * @return
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i=0;i<employees.length;i++){
            if (employees[i].getId()==id){
                return employees[i];
            }
        }

        throw new TeamException("找不到指定的员工");
    }
}

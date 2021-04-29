package com.liyi.study.base.project03.domain;

import com.liyi.study.base.project03.service.Status;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/20 10:26  星期二
 */
public class Programmer extends Employee{
    private int memberId;//开发团队的id

    private Status status=Status.FREE;

    private Equipment equipment;



    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer() {

    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);

        this.equipment = equipment;
    }

    @Override
    public String toString() {

        return super.toString()+"\t程序员\t"+status+"\t\t\t"+equipment.getDescription();
    }

    public String getDetailsForTeam(){
        return memberId+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t程序员";
    }
}



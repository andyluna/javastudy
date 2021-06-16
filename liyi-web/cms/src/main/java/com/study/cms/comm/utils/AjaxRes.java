package com.study.cms.comm.utils;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/16 22:58  星期三
 */
public class AjaxRes {
    private int code;
    private String define;
    public AjaxRes(){}
    public AjaxRes(int code, String define) {
        this.code = code;
        this.define = define;
    }

    public static AjaxRes success( ){
        return  success("操作成功");
    }
    public static AjaxRes success( String define){
        return  new AjaxRes(0,define);
    }
    public static AjaxRes error(){
        return error("操作失败");
    }

    public static AjaxRes error( String define){
        return  new AjaxRes(1,define);
    }







    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDefine() {
        return define;
    }

    public void setDefine(String define) {
        this.define = define;
    }

    @Override
    public String toString() {

        return "{\"code\":"+code+",\"define\":\""+define+"\"}";
    }
}

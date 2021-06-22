package com.study.cms.comm.vo;

import java.util.List;

/**
 * 封装分页所用的 对象
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/18 0:02  星期五
 */
public class PageRes {
    private long total;//总记录条数
    private int totalPage;//总分页数
    private int curPage;//当前第几页
    private long pageSize;//每页显示的大小
    private List<?> data;//真实的当前页的数据

    public PageRes() {
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageRes{" +
                "\ntotal=" + total +
                ", \ntotalPage=" + totalPage +
                ", \ncurPage=" + curPage +
                ", \npageSize=" + pageSize +
                ", \ndata=" + data +
                '}';
    }
}

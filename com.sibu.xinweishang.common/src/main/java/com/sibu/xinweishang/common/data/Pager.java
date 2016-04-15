package com.sibu.xinweishang.common.data;


import java.util.List;

public class Pager<T> {
    private List<T> datas;
    private int pageOffset; //当前的页数
    private int pageSize; //一页显示多少条
    private int totalRecord; //总记录数
    private int totalPage; //总页数
    private Object ex = new NullObjectBean();//扩展字段

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {

        this.totalRecord = totalRecord;
        this.setTotalPage(totalRecord);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        if (totalPage % pageSize == 0) {
            this.totalPage = totalPage / pageSize;
        } else {
            this.totalPage = (totalPage / pageSize) + 1;
        }
    }

    public Object getEx() {
        return ex;
    }

    public void setEx(Object ex) {
        this.ex = ex;
    }
}
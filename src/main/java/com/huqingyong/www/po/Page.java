package com.huqingyong.www.po;


import java.util.List;

public class Page<T> {

    public static final Integer PAGE_SIZE=4;
    private Integer pageNo;
    private Integer pageSize=PAGE_SIZE;
    private Integer pageTotal;
    private Integer PageTotalCount;
    private List<T> items;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageTotal, Integer pageTotalCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotal = pageTotal;
        PageTotalCount = pageTotalCount;
        this.items = items;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return PageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        PageTotalCount = pageTotalCount;
    }

    public List<T>getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        //对数据边界的有效检查（判断数据是否合理才保存）
        if(pageNo<1){pageNo=1;}
        if(pageNo>pageTotal){pageNo=pageTotal;}
        if(pageTotal==0){pageNo=1;}
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotal=" + pageTotal +
                ", PageTotalCount=" + PageTotalCount +
                ", items=" + items +
                '}';
    }
}

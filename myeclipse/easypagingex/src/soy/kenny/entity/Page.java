package soy.kenny.entity;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private Integer currPageNO;//当前页号OK
    private Integer perPageSize = 3;//每页显示记录数，默认为3条记录OK
    private Integer allRecordNO;//总记录数OK
    private Integer allPageNO;//总页号OK
    private List<Emp> empList = new ArrayList<Emp>();//该本页显示的内容OK
    public Page(){}
    public Integer getCurrPageNO() {
        return currPageNO;
    }
    public void setCurrPageNO(Integer currPageNO) {
        this.currPageNO = currPageNO;
    }
    public Integer getPerPageSize() {
        return perPageSize;
    }
    public void setPerPageSize(Integer perPageSize) {
        this.perPageSize = perPageSize;
    }
    public Integer getAllRecordNO() {
        return allRecordNO;
    }
    public void setAllRecordNO(Integer allRecordNO) {
        this.allRecordNO = allRecordNO;
    }
    public Integer getAllPageNO() {
        return allPageNO;
    }
    public void setAllPageNO(Integer allPageNO) {
        this.allPageNO = allPageNO;
    }
    public List<Emp> getEmpList() {
        return empList;
    }
    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }
}
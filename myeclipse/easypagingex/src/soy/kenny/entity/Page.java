package soy.kenny.entity;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private Integer currPageNO;//��ǰҳ��OK
    private Integer perPageSize = 3;//ÿҳ��ʾ��¼����Ĭ��Ϊ3����¼OK
    private Integer allRecordNO;//�ܼ�¼��OK
    private Integer allPageNO;//��ҳ��OK
    private List<Emp> empList = new ArrayList<Emp>();//�ñ�ҳ��ʾ������OK
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
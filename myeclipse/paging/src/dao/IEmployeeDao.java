package dao;

import utils.PageBean;

public interface IEmployeeDao {
    public void getAll(PageBean pb);
    
    public int getTotalCount();
}

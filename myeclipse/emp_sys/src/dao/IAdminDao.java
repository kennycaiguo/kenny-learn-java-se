package dao;

import entity.Admin;

public interface IAdminDao {
 
    public Admin findByNameAndPwd(Admin admin);
    
    
}

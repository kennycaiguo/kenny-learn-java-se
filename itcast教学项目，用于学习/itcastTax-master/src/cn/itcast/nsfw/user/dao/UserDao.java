package cn.itcast.nsfw.user.dao;

import java.io.Serializable;
import java.util.List;

import cn.itcast.core.dao.BaseDao;
import cn.itcast.nsfw.user.entity.User;
import cn.itcast.nsfw.user.entity.UserRole;

public interface UserDao extends BaseDao<User> {
	
	//根据账号及ID查询用户
	public List<User> findUserByAccountAndId(String id, String account);
	
	//保存用户角色
	public void saveUserRole(UserRole userRole);
	
	//根据用户ID删除用户角色
	public void deleteUserRoleByUserId(Serializable id);
	
	//根据用户ID获取对应所有用户角色
	public List<UserRole> getUserRolesByUserId(String id);
	
	//login
	public List<User> findUserByAccountAndPassword(String account,
			String password);

}

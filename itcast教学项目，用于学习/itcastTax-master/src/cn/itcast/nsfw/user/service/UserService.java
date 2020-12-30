package cn.itcast.nsfw.user.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.itcast.core.exception.ServiceException;
import cn.itcast.core.service.BaseService;
import cn.itcast.nsfw.user.entity.User;
import cn.itcast.nsfw.user.entity.UserRole;

public interface UserService extends BaseService<User> {
	//导出用户列表
	public void exportExcel(List<User> userList,ServletOutputStream outputStream);
	//导入用户列表
	public void importExcel(File userExcel, String userExcelFileName);
	//根据账号及ID查询用户
	public List<User> findUserByAccountAndId(String id, String account);
	//保存用户及对应角色
	public void saveUserAndRole(User user, String... roleIds);
	//更新用户及对应角色
	public void updateUserAndRole(User user, String... roleIds);
	//根据用户ID获取对应所有用户角色
	public List<UserRole> getUserRolesByUserId(String id);
	//登录验证
	public List<User> findUserByAccountAndPassword(String account,
			String password);	
}

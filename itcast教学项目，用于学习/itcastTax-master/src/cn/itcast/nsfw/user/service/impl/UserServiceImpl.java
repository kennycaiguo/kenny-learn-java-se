package cn.itcast.nsfw.user.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import cn.itcast.core.service.impl.BaseServiceImpl;
import cn.itcast.core.util.ExcelUtil;
import cn.itcast.nsfw.role.entity.Role;
import cn.itcast.nsfw.user.dao.UserDao;
import cn.itcast.nsfw.user.entity.User;
import cn.itcast.nsfw.user.entity.UserRole;
import cn.itcast.nsfw.user.entity.UserRoleId;
import cn.itcast.nsfw.user.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	private UserDao userDao;
	@Resource
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}
	public void delete(Serializable id) {
		userDao.delete(id);
		//删除用户对应的应用权限
		userDao.deleteUserRoleByUserId(id);
	}

	@Override
	public void exportExcel(List<User> userList,ServletOutputStream outputStream) {
		ExcelUtil.exportUserExcel(userList, outputStream);
	}

	@Override
	public void importExcel(File userExcel, String userExcelFileName) {
		try {
			FileInputStream fileInputStream=new FileInputStream(userExcel);
			boolean is03=userExcelFileName.matches("^.+\\.(?i)(xls)$");
			//1、读取工作簿
			Workbook workbook=is03?new HSSFWorkbook(fileInputStream):new XSSFWorkbook(fileInputStream);
			
			//2、读取工作表
			Sheet sheet=workbook.getSheetAt(0);
			//3、读取行
			if (sheet.getPhysicalNumberOfRows()>2) {
				for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
					User user=new User();
					//4、读取单元格
					Row row=sheet.getRow(i);
					//用户名
					Cell cell0=row.getCell(0);
					user.setName(cell0.getStringCellValue());
					//账号
					Cell cell1=row.getCell(1);
					user.setAccount(cell1.getStringCellValue());
					//部门
					Cell cell2=row.getCell(2);
					user.setDept(cell2.getStringCellValue());
					//性别
					Cell cell3=row.getCell(3);
					user.setGender(cell3.getStringCellValue().equals("男")?true:false);
					//手机号
					String mobile="";
					Cell cell4=row.getCell(4);
					try {
						mobile=cell4.getStringCellValue();
					} catch (Exception e) {
						double dMobile=cell4.getNumericCellValue();
						mobile=BigDecimal.valueOf(dMobile).toString();
					}
					user.setMobile(mobile);
					//邮箱
					Cell cell5=row.getCell(5);
					user.setEmail(cell5.getStringCellValue());
					//生日
					Cell cell6=row.getCell(6);
					if (cell6.getDateCellValue()!=null) {
						user.setBirthday(cell6.getDateCellValue());
					}
					//默认用户密码123456
					user.setPassword("123456");
					//默认用户状态有效
					user.setState(User.USER_STATE_VALID);

					//5、保存用户
					save(user);
				}
			}
			workbook.close();
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> findUserByAccountAndId(String id, String account) {
		return userDao.findUserByAccountAndId(id,account);
	}

	@Override
	public void saveUserAndRole(User user, String... roleIds) {
		//1.保存用户
		save(user);
		//2. 保存用户对应的角色
		if (roleIds!=null) {
			for (String roleId:roleIds) {
				userDao.saveUserRole(new UserRole(new UserRoleId(new Role(roleId),user.getId())));
			}
		}	
	}

	@Override
	public void updateUserAndRole(User user, String... roleIds) {
		//1.删除用户对应角色
		userDao.deleteUserRoleByUserId(user.getId());
		//2.保存用户
		update(user);
		//3. 保存用户对应的角色
		if (roleIds!=null) {
			for (String roleId:roleIds) {
				userDao.saveUserRole(new UserRole(new UserRoleId(new Role(roleId),user.getId())));
			}
		}
	}

	@Override
	public List<UserRole> getUserRolesByUserId(String id) {
		return userDao.getUserRolesByUserId(id);
	}

	@Override
	public List<User> findUserByAccountAndPassword(String account, String password) {
		return userDao.findUserByAccountAndPassword(account,password);
	}

}

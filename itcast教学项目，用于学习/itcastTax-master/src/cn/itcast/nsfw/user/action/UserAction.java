package cn.itcast.nsfw.user.action;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.core.action.BaseAction;
import cn.itcast.core.util.QueryHelper;
import cn.itcast.nsfw.role.service.RoleService;
import cn.itcast.nsfw.user.entity.User;
import cn.itcast.nsfw.user.entity.UserRole;
import cn.itcast.nsfw.user.service.UserService;

public class UserAction extends BaseAction {
	
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	private User user;
	private String strName;
	
	//文件上传
	private File headImg;
	private String headImgContentType;
	private String headImgFileName;
	//用户列表上传
	private File userExcel;
	private String userExcelContentType;
	private String userExcelFileName;
	
	private String[] userRoleIds;

	//列表页面
	public String listUI() throws Exception{
		QueryHelper queryHelper=new QueryHelper(User.class, "u");
		try {
			if (user!=null) {
				if (StringUtils.isNotBlank(user.getName())) {
					//解决中文传参乱码
					user.setName(URLDecoder.decode(user.getName(),"utf-8"));
					queryHelper.addCondition("u.name like ?", "%"+user.getName()+"%");
				}
				queryHelper.addCondition("u.state=?", "1");
			}
			//userList=userService.findObject(queryHelper);
			pageResult=userService.getPageResult(queryHelper,getPageNo(),getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}	
		return "listUI";
	}
	//跳转到新增页面
	public String addUI() throws Exception{
		//加载角色列表
		ActionContext.getContext().getContextMap().put("roleList", roleService.findObject());
		
		return "addUI";
	}
	//保存新增
	public String add(){
		if(user != null){
			//处理头像
			try {
				if (headImg!=null) {
					//1.保存头像到upload/user
					// 获取保存路径绝对地址
					String filePath=ServletActionContext.getServletContext().getRealPath("upload/user");
					//UUID.randomUUID().toString()是java JDK提供的一个自动生成主键的方法。UUID(Universally Unique Identifier)全局唯一标识符,
					//是指在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的，是由一个十六位的数字组成,表现出来的形式。
					String fileName=UUID.randomUUID().toString().replaceAll("-", "")+headImgFileName.substring(headImgFileName.lastIndexOf("."));
					//复制文件
					FileUtils.copyFile(headImg, new File(filePath,fileName));
					//2.设置头像路径	
					user.setHeadImg("user/"+fileName);//   user/123.jgp
				}
				userService.saveUserAndRole(user,userRoleIds);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "list";
	}
	//跳转到编辑页面
	public String editUI() throws Exception{
		//加载角色列表
		ActionContext.getContext().getContextMap().put("roleList", roleService.findObject());
		if (user != null && user.getId() != null) {
			//解决查询条件被覆盖的问题
			strName=user.getName();
			user = userService.findObjectById(user.getId());
			//设置角色回显
			List<UserRole> list=userService.getUserRolesByUserId(user.getId());
			if (list!=null&&list.size()>0) {
				userRoleIds=new String[list.size()];
				for (int i = 0; i < list.size(); i++) {
					userRoleIds[i]=list.get(i).getId().getRole().getRoleId();
				}
			}
		}
		return "editUI";
	}
	//保存编辑
	public String edit(){
		if(user != null){
			try {
				if (headImg!=null) {
					//1.保存头像到upload/user
					// 获取保存路径绝对地址
					String filePath=ServletActionContext.getServletContext().getRealPath("upload/user");
					//UUID.randomUUID().toString()是java JDK提供的一个自动生成主键的方法。UUID(Universally Unique Identifier)全局唯一标识符,
					//是指在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的，是由一个十六位的数字组成,表现出来的形式。
					String fileName=UUID.randomUUID().toString().replaceAll("-", "")+headImgFileName.substring(headImgFileName.lastIndexOf("."));
					//复制文件
					FileUtils.copyFile(headImg, new File(filePath,fileName));
					//2.设置头像路径	
					user.setHeadImg("user/"+fileName);//   user/123.jgp
				}
				userService.updateUserAndRole(user,userRoleIds);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "list";
	}
	//删除
	public String delete(){
		if(user != null && user.getId() != null){
			//解决查询条件被覆盖的问题
			strName=user.getName();
			userService.delete(user.getId());
		}
		return "list";
	}
	//批量删除
	public String deleteSelected(){
		//解决查询条件被覆盖的问题
		strName=user.getName();
		if(selectedRow != null){
			for(String id: selectedRow){
				userService.delete(id);
			}
		}
		return "list";
	}
	//
	//导出用户列表
		public void exportExcel(){
			try {
				//1、查找用户列表
				//userList = userService.findObject();
				//2、导出
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/x-excel");
				response.setHeader("Content-Disposition", "attachment;filename=" + new String("用户列表.xls".getBytes(), "ISO-8859-1"));
				ServletOutputStream outputStream = response.getOutputStream();
				userService.exportExcel(userService.findObject(), outputStream);
				if(outputStream != null){
					outputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//导入用户列表
		public String importExcel(){
			//1、获取excel文件
			if(userExcel != null){
				//是否是excel
				if(userExcelFileName.matches("^.+\\.(?i)((xls)|(xlsx))$")){
					//2、导入
					userService.importExcel(userExcel, userExcelFileName);
				}
			}
			return "list";
		}
		//校验账号是否唯一
		public void verifyAccount() {
			try {
				if (user!=null&&StringUtils.isNotBlank(user.getAccount())) {
					//
					List<User> list=userService.findUserByAccountAndId(user.getId(),user.getAccount());
					String strResult="true";
					if (list!=null&&list.size()>0) {
						strResult="false";
					}
					//输出
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setContentType("text/html");
					ServletOutputStream outputStream = response.getOutputStream();
					outputStream.write(strResult.getBytes());
					outputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public File getHeadImg() {
		return headImg;
	}
	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}
	public String getHeadImgContentType() {
		return headImgContentType;
	}
	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}
	public String getHeadImgFileName() {
		return headImgFileName;
	}
	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}
	public File getUserExcel() {
		return userExcel;
	}
	public void setUserExcel(File userExcel) {
		this.userExcel = userExcel;
	}
	public String getUserExcelContentType() {
		return userExcelContentType;
	}
	public void setUserExcelContentType(String userExcelContentType) {
		this.userExcelContentType = userExcelContentType;
	}
	public String getUserExcelFileName() {
		return userExcelFileName;
	}
	public void setUserExcelFileName(String userExcelFileName) {
		this.userExcelFileName = userExcelFileName;
	}
	public String[] getUserRoleIds() {
		return userRoleIds;
	}
	public void setUserRoleIds(String[] userRoleIds) {
		this.userRoleIds = userRoleIds;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	
}

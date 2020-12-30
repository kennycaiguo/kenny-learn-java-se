package cn.itcast.nsfw.role.action;

import java.net.URLDecoder;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.core.action.BaseAction;
import cn.itcast.core.constant.Constant;
import cn.itcast.core.util.QueryHelper;
import cn.itcast.nsfw.info.entity.Info;
import cn.itcast.nsfw.role.entity.Role;
import cn.itcast.nsfw.role.entity.RolePrivilege;
import cn.itcast.nsfw.role.entity.RolePrivilegeId;
import cn.itcast.nsfw.role.service.RoleService;

public class RoleAction extends BaseAction {
	
	@Resource
	private RoleService roleService;
	private Role role;
	private String[] privilegeIds;
	private String strName;

	//列表页面
	public String listUI() throws Exception{
		//加载权限
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		QueryHelper queryHelper=new QueryHelper(Role.class, "r");
		try {
			if (role!=null) {
				if (StringUtils.isNotBlank(role.getName())) {
					//解决中文传参乱码
					role.setName(URLDecoder.decode(role.getName(),"utf-8"));
					queryHelper.addCondition("r.name like ?", "%"+role.getName()+"%");
				}
				queryHelper.addCondition("r.state=?", "1");
			}
			pageResult=roleService.getPageResult(queryHelper,getPageNo(),getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}	
		return "listUI";
	}
	//跳转到新增页面
	public String addUI(){
		//加载权限
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		return "addUI";
	}
	
	//保存新增
	public String add(){
		try {
			if(role != null){		
				HashSet<RolePrivilege> set=new HashSet<RolePrivilege>();
				for (int i = 0; i < privilegeIds.length; i++) {
					set.add(new RolePrivilege(new RolePrivilegeId(role, privilegeIds[i])));
				}
				role.setRolePrivileges(set);
				roleService.save(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	//跳转到编辑页面
	public String editUI(){
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		if (role != null && role.getRoleId() != null) {
			//解决查询条件被覆盖的问题
			strName=role.getName();
			role = roleService.findObjectById(role.getRoleId());
			//处理权限回显
			if (role.getRolePrivileges()!=null) {
				privilegeIds = new String[role.getRolePrivileges().size()];
				int i=0;
				for (RolePrivilege rp:role.getRolePrivileges()) {
					privilegeIds[i++]=rp.getId().getCode();
				}
			}
		}
		return "editUI";
	}
	//保存编辑
	public String edit(){
		if(role != null){
			try {
				HashSet<RolePrivilege> set=new HashSet<RolePrivilege>();
				for (int i = 0; i < privilegeIds.length; i++) {
					set.add(new RolePrivilege(new RolePrivilegeId(role, privilegeIds[i])));
				}
				role.setRolePrivileges(set);
				roleService.update(role);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "list";
	}
	//删除
	public String delete(){
		if(role != null && role.getRoleId() != null){
			//解决查询条件被覆盖的问题
			strName=role.getName();
			roleService.delete(role.getRoleId());
		}
		return "list";
	}
	//批量删除
	public String deleteSelected(){
		//解决查询条件被覆盖的问题
		strName=role.getName();
		if(selectedRow != null){
			for(String id: selectedRow){
				roleService.delete(id);
			}
		}
		return "list";
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}	
}

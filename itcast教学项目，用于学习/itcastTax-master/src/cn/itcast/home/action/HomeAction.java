package cn.itcast.home.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import cn.itcast.core.constant.Constant;
import cn.itcast.core.util.QueryHelper;
import cn.itcast.nsfw.complain.entity.Complain;
import cn.itcast.nsfw.complain.service.ComplainService;
import cn.itcast.nsfw.info.entity.Info;
import cn.itcast.nsfw.info.service.InfoService;
import cn.itcast.nsfw.user.entity.User;
import cn.itcast.nsfw.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	@Resource
	private UserService userService;
	@Resource
	private ComplainService complainService;
	
	@Resource
	private InfoService infoService;
	
	private Complain comp;
	private Info info;
	private List<Info> infoList;
	private List<Complain> complainList;

	
	private Map<String, Object> retrue_map;
	
	//跳转到首页
	public String execute(){
		//加载信息类型
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		//加载信息列表
		QueryHelper queryHelper1=new QueryHelper(Info.class, "i");
		queryHelper1.addOrderByProperty("i.createTime", QueryHelper.ORDER_BY_DESC);
		infoList=infoService.getPageResult(queryHelper1, 1, 5).getItems();
		//ActionContext.getContext().getSession().put("infoList", infoList);

		
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute(Constant.USER);
		//加载状态集合
		ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
		//加载信息列表
		QueryHelper queryHelper2=new QueryHelper(Complain.class, "c");
		queryHelper2.addOrderByProperty("c.compTime", QueryHelper.ORDER_BY_ASC);
		queryHelper2.addOrderByProperty("c.state", QueryHelper.ORDER_BY_DESC);
		complainList=complainService.getPageResult(queryHelper2, 1, 6).getItems();	
		//ActionContext.getContext().getSession().put("complainList", complainList);
		
		return "home";
	}
	
	//跳转到我要投诉
	public String complainAddUI(){
		
		return "complainAddUI";
	}
	
	public void getUserJson(){
		try {
			//1. 获取部门
			String dept=ServletActionContext.getRequest().getParameter("dept");
			if (StringUtils.isNotBlank(dept)) {
				QueryHelper queryHelper=new QueryHelper(User.class, "u");
				queryHelper.addCondition("u.dept like ?", "%"+dept);
				//2. 根据部门查询用户列表
				List<User> userList=userService.findObject(queryHelper);
				//创建json对象
				JSONObject jso=new JSONObject();
				jso.put("msg", "success");
				jso.accumulate("userList", userList);
				
				//3. 输出用户列表已json形式字符串输出
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(jso.toString().getBytes("utf-8"));
				outputStream.close();		
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	}
	
	public String getUserJson2(){
		try {
			//1. 获取部门
			String dept=ServletActionContext.getRequest().getParameter("dept");
			if (StringUtils.isNotBlank(dept)) {
				QueryHelper queryHelper=new QueryHelper(User.class, "u");
				queryHelper.addCondition("u.dept like ?", "%"+dept);
				//2. 根据部门查询用户列表
				retrue_map=new HashMap<String, Object>();
				retrue_map.put("msg", "success");
				retrue_map.put("userList", userService.findObject(queryHelper));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 	
		return SUCCESS;
	}
	
	//保存投诉
	public void complainAdd(){
		try {
			if(comp!=null){
				comp.setState(Complain.COMPLAIN_STATE_UNDONE);
				comp.setCompTime(new Timestamp(new Date().getTime()));
				complainService.save(comp);
				
				//3. 输出投诉结果信息
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write("success".getBytes("utf-8"));
				outputStream.close();		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	//查看信息
	public String infoViewUI(){
		//加载信息类型
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		if (info!=null) {
			info=infoService.findObjectById(info.getInfoId());
		}
		return "infoViewUI";
	}
	
	//查看投诉信息
	public String complainViewUI(){
		//加载tousu状态集合
		ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
		if (comp!=null) {
			comp=complainService.findObjectById(comp.getCompId());
		}
		return "complainViewUI";
	}

	public Map<String, Object> getRetrue_map() {
		return retrue_map;
	}

	public void setRetrue_map(Map<String, Object> retrue_map) {
		this.retrue_map = retrue_map;
	}

	public Complain getComp() {
		return comp;
	}

	public void setComp(Complain comp) {
		this.comp = comp;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public List<Info> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<Info> infoList) {
		this.infoList = infoList;
	}

	public List<Complain> getComplainList() {
		return complainList;
	}

	public void setComplainList(List<Complain> complainList) {
		this.complainList = complainList;
	}
}

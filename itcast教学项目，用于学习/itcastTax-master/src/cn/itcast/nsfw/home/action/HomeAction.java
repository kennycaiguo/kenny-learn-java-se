package cn.itcast.nsfw.home.action;

import cn.itcast.core.action.BaseAction;

public class HomeAction extends BaseAction {
	//跳转纳税服务系统首页
	public String frame(){
		return "frame";
	}
	//跳转纳税服务系统首页-顶部
	public String top(){
		return "top";
	}
	//跳转纳税服务系统首页-左侧
	public String left(){
		return "left";
	}
}

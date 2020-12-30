package cn.itcast.nsfw.complain.action;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.core.action.BaseAction;
import cn.itcast.core.util.QueryHelper;
import cn.itcast.nsfw.complain.entity.Complain;
import cn.itcast.nsfw.complain.entity.ComplainReply;
import cn.itcast.nsfw.complain.service.ComplainService;

public class ComplainAction extends BaseAction {
	@Resource
	private ComplainService complainService;
	private Complain complain;
	private String startTime;
	private String endTime;
	private ComplainReply reply;
	private String strTitle;
	private String strState;
	private Map<String, Object> statisticMap; 
	
	//列表
	public String listUI(){
		//加载状态集合
		ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
		try {
			QueryHelper queryHelper=new QueryHelper(Complain.class, "c");
			if (StringUtils.isNotBlank(startTime)) {
				startTime=URLDecoder.decode(startTime, "utf-8");
				queryHelper.addCondition("c.compTime >=?", DateUtils.parseDate(startTime, "yyyy-MM-dd HH:mm"));
			}
			if (StringUtils.isNotBlank(endTime)) {
				endTime=URLDecoder.decode(endTime, "utf-8");
				queryHelper.addCondition("c.compTime <=?", DateUtils.parseDate(endTime, "yyyy-MM-dd HH:mm"));
			}
			if (complain!=null) {
				if (StringUtils.isNotBlank(complain.getState())) {
					queryHelper.addCondition("c.state=?", complain.getState());
				}
				if (StringUtils.isNotBlank(complain.getCompTitle())) {
					complain.setCompTitle(URLDecoder.decode(complain.getCompTitle(), "utf-8"));
					queryHelper.addCondition("c.compTitle like ?", "%"+complain.getCompTitle()+"%");
				}				
			}
			
			//按状态升序
			queryHelper.addOrderByProperty("c.state", QueryHelper.ORDER_BY_ASC);
			//按照投诉时间升序
			queryHelper.addOrderByProperty("c.compTime", QueryHelper.ORDER_BY_ASC);
			pageResult=complainService.getPageResult(queryHelper, getPageNo(), getPageSize());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "listUI";
	}
	
	//跳转到处理页面
	public String dealUI(){
		//加载状态集合
		ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
		if (complain!=null) {
			strTitle=complain.getCompTitle();
			strState=complain.getState();
			complain=complainService.findObjectById(complain.getCompId());
		}		
		return "dealUI";
	}
	
	public String deal(){
		//更新投诉状态为已处理
		Complain tem=complainService.findObjectById(complain.getCompId());
		if (!Complain.COMPLAIN_STATE_DONE.equals(tem.getState())) {
			tem.setState(Complain.COMPLAIN_STATE_DONE);
		}
		//保存回复信息
		if (reply!=null) {
			reply.setComplain(tem);
			reply.setReplyTime(new Timestamp(new Date().getTime()));
			tem.getComplainReplies().add(reply);
		}
		complainService.update(tem);
		return "list";
	}
	
	//跳转到统计页面
	public String annualStatisticChartUI(){
		return "annualStatisticChartUI";
	}
	
	//根据年度获取该年度下的统计数
	public String getAnnualStatisticData(){
		//1、获取年份
		HttpServletRequest request=ServletActionContext.getRequest();
		int year=0;
		if (request.getParameter("year")!=null) {
			year=Integer.valueOf(request.getParameter("year"));
		}else {
			//默认为当前年份
			year=Calendar.getInstance().get(Calendar.YEAR);
		}
		//2、统计年度的每个月的投诉数并输出json格式字符串
		statisticMap=new HashMap<String, Object>();
		statisticMap.put("msg", "success");
		statisticMap.put("chartData", complainService.getAnnualStatisticDataByYear(year));
		return "annualStatisticData";
	}
	
	
	public Complain getComplain() {
		return complain;
	}

	public void setComplain(Complain complain) {
		this.complain = complain;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public ComplainReply getReply() {
		return reply;
	}

	public void setReply(ComplainReply reply) {
		this.reply = reply;
	}

	public String getStrTitle() {
		return strTitle;
	}

	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	public String getStrState() {
		return strState;
	}

	public void setStrState(String strState) {
		this.strState = strState;
	}

	public Map<String, Object> getStatisticMap() {
		return statisticMap;
	}

	public void setStatisticMap(Map<String, Object> statisticMap) {
		this.statisticMap = statisticMap;
	}
}

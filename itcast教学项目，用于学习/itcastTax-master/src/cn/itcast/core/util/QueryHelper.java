package cn.itcast.core.util;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {
	private String fromClause="";
	private String whereClause="";
	private String orderByClause="";
	
	private List<Object> parameters;
	
	public static String ORDER_BY_DESC="DESC";//降序
	public static String ORDER_BY_ASC="ASC";//升序
	
	/**
	 * 构造from语句
	 * @param clazz 实体类
	 * @param alias实体类对应别名
	 */
	public QueryHelper(Class<?> clazz,String alias){
		fromClause="FROM "+clazz.getSimpleName()+" "+alias;
	}
	
	/**
	 *  构造where语句
	 * @param condition 查询条件语句 例如：i.title like ?
	 * @param params 查询条件语句中？对应查询条件值 例如：%标题%
	 */
	public void addCondition(String condition,Object... params){
		if (whereClause.length()>1) {//非第一次查询条件
			whereClause+=" AND "+condition;
		}else {//第一次查询条件
			whereClause+=" WHERE " +condition;
		}
		
		if (parameters==null) {
			parameters=new ArrayList<Object>();
		}
		if (parameters!=null) {
			for (Object param:params) {
				parameters.add(param);
			}
		}
	}
	/**
	 * 构造order by 子句
	 * @param peoperty 排序属性 如：i.createTime
	 * @param order 排序顺序 如：DESC或者ASC
	 */
	public void addOrderByProperty(String peoperty,String order) {
		if (orderByClause.length()>1) {//非第一个排序属性
			orderByClause+=","+peoperty+" "+order;
		}else {//第一个排序属性
			orderByClause+=" ORDER BY " +peoperty+" "+order;
		}
	}
	
	//查询hql语句
	public String  getQuery(){
		return fromClause+whereClause+orderByClause;
	}
	//查询hql语句中？对应条件值集合
	public List<Object> getParameters(){	
		return parameters;		
	}
	//查询总记录数
	public String  getQueryCount(){
		return "SELECT COUNT(*) "+fromClause+whereClause;
	}
}

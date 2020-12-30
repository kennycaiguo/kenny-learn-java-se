package cn.itcast.core.service;

import java.io.Serializable;
import java.util.List;

import cn.itcast.core.page.PageResult;
import cn.itcast.core.util.QueryHelper;
public interface BaseService<T> {
	//增加
	public void save(T entity);
	//更新
	public void update(T entity);
	//删除
	public void delete(Serializable id);
	//根据ID查询
	public T findObjectById(Serializable id);
	//查找列表
	public List<T> findObject();
	//条件查询实体列表——此方法不建议使用
	@Deprecated
	public List<T> findObject(String sql, List<Object> parameters);
	//条件查询实体列表——查询助手QueryHelper
	public List<T> findObject(QueryHelper queryHelper);
	//分页查询及查询助手QueryHelper
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);

}

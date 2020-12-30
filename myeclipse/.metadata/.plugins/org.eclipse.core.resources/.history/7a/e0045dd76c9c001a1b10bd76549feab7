package soy.kenny.dao.inter;

import java.util.List;

import soy.kenny.entity.Emp;

public interface IEmpDao {

	/**
     * 获取总记录数
     * @return 总记录数
     */
    public Integer getAllRecord() throws Exception;
    /**
     * 分批查询所有记录
     * @param start 表示 从第几条记录开始
     * @param end   表示 到第几条记录结束
     * @return      表示 start到end之间的记录集合，包含start和end
     */
    public List<Emp> findAllRecord(int start,int end) throws Exception;
}

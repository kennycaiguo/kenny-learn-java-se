package soy.kenny.service.inter;

import soy.kenny.entity.Page;

public interface IEmpService {
	 /**
     * 根据页号获取该页需要显示的内容
     * @param currPageNO 当前页号
     * @return 封装该页需要显示的内容
     */
    public Page show(int currPageNO) throws Exception;
}
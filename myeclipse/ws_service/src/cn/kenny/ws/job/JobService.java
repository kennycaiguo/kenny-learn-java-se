package cn.kenny.ws.job;

import javax.jws.WebService;

/**
 * 
 * 面向接口的webservice发布方式
 * @author Administrator
 *
 */
@WebService
public interface JobService {
   public String getJob();
}

package cn.kenny.app06;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;



@SuppressWarnings("deprecation")
public class EmpAction extends AbstractCommandController{
	public EmpAction(){
		System.out.println("EmpAction()");
		//将表单参数封装到Emp对象中
		this.setCommandClass(Emp.class);
		
	}
	
	/*
	 * 自定义日期转换器,将String转换为Date
	 * */
	 @Override
     protected void initBinder(HttpServletRequest request, 
    		 ServletRequestDataBinder binder) throws Exception {
		 //向spring内部注册一个自定义类型转换器
		 //参数1：需要将String类转换成的目标类型
		 //参数2：自定义转换规则
		 //true表示该字段可以为空
		 binder.registerCustomEditor(Date.class, 
				 new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		 
	 };
	
     /*
      * 
      * (non-Javadoc)
      * @see org.springframework.web.servlet.mvc.AbstractCommandController#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
      */
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object obj, BindException error)throws Exception {
		 
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message", "增加员工成功"+obj.toString());
		System.out.println("handle()");
		Emp emp=(Emp) obj;
		System.out.println(emp.getUsername()+":"+emp.getHiredate().toLocaleString());
		modelAndView.addObject("emp", emp);
		modelAndView.setViewName("/jsp/success.jsp");
		return modelAndView;
	}
  
}

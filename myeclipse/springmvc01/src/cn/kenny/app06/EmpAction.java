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
		//����������װ��Emp������
		this.setCommandClass(Emp.class);
		
	}
	
	/*
	 * �Զ�������ת����,��Stringת��ΪDate
	 * */
	 @Override
     protected void initBinder(HttpServletRequest request, 
    		 ServletRequestDataBinder binder) throws Exception {
		 //��spring�ڲ�ע��һ���Զ�������ת����
		 //����1����Ҫ��String��ת���ɵ�Ŀ������
		 //����2���Զ���ת������
		 //true��ʾ���ֶο���Ϊ��
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
		modelAndView.addObject("message", "����Ա���ɹ�"+obj.toString());
		System.out.println("handle()");
		Emp emp=(Emp) obj;
		System.out.println(emp.getUsername()+":"+emp.getHiredate().toLocaleString());
		modelAndView.addObject("emp", emp);
		modelAndView.setViewName("/jsp/success.jsp");
		return modelAndView;
	}
  
}

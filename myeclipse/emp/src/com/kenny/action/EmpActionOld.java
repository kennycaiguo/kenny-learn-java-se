package com.kenny.action;

import java.util.Date;
import java.text.SimpleDateFormat;
 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.kenny.entity.Emp;
import com.kenny.service.EmpService;

//Ա������ģ��
//������
@SuppressWarnings("deprecation")
public class EmpActionOld extends AbstractCommandController{
	
	 private EmpService empService;
	 public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	//���?�����װ��Emp����
      public EmpActionOld(){
    	  this.setCommandClass(Emp.class);
      }
      
      //�������ڸ�ʽ���Զ���String-��dateת����
      @Override
    protected void initBinder(HttpServletRequest request,
    		ServletRequestDataBinder binder) throws Exception {
    	 System.out.println("binder");
    	 binder.registerCustomEditor(Date.class, 
    			 new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
      
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object obj, BindException error)
			throws Exception {
		
		    ModelAndView modelAndView=new ModelAndView();
		     Emp emp=(Emp)obj;
		     //System.out.println(emp.getHiredate().toLocaleString());
		     empService.register(emp);
		     
		     modelAndView.addObject("message", "����Ա���ɹ�"+obj.toString());
		     modelAndView.setViewName("success");
		return modelAndView;
	}
    
}

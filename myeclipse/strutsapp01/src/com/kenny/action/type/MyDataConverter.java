package com.kenny.action.type;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyDataConverter extends StrutsTypeConverter{
	 
	//����һ�����ڸ�ʽת�������飬������Ҫ�ĸ�ʽ
     DateFormat[] df= {
    		new SimpleDateFormat("yyyy-MM-dd"),
    		new SimpleDateFormat("yyyyMMdd"),
    		new SimpleDateFormat("yyyy��-MM��-dd��"),
    		new SimpleDateFormat("yyyy��MM��dd��"),
    		new SimpleDateFormat("yyyy��/MM��/dd��"),
    		new SimpleDateFormat("yy��-MM��-dd��"),
    		new SimpleDateFormat("yy-MM-dd"),
    		new SimpleDateFormat("yy/MM/dd"),
    		new SimpleDateFormat("yyMMdd"),
     };
     
	@Override
	public Object convertFromString(Map context, String[] value, Class toClass) {
		 if(value==null ||value.length==0) {
			 return null;
		 }
		 if(Date.class!=toClass) {
			 return null;
		 }
		 for (int i = 0; i < df.length; i++) {
			 try {
					return df[i].parse(value[0]);
				} catch (Exception e) {
					continue;
				}
		}
		 
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}
    
}

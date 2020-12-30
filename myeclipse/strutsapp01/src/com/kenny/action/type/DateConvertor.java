package com.kenny.action.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConvertor extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] value, Class toClass) {
		
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(value[0]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		 
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}

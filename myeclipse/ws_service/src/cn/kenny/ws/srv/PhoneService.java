package cn.kenny.ws.srv;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import cn.kenny.ws.model.Phone;

@WebService //声明webservice
public class PhoneService {
	public Phone getPhoneInfo(String osNane) {
		Phone phone=new Phone();
		if(osNane.equals("android")) {
			phone.setName("android");
			phone.setOwner("google");
			phone.setTotal(80);
		}else if(osNane.equals("ios")) {
			phone.setName("ios");
			phone.setOwner("Apple inc");
			phone.setTotal(15);
		}else{
			phone.setName("windows phone");
			phone.setOwner("microsoft");
			phone.setTotal(5);
		}
		return phone;
		
	}

	public static void main(String[] args) {
		 String address1="http://127.0.0.1:8888/ws/phoneservice";
		 String address2="http://127.0.0.1:8888/ws/phoneManage";
		//Object implementor;
		//发布webservice
		/**
		 * @param
		 * address:服务的地址
		 * implementor：服务的实现对象
		 */
		Endpoint.publish(address1, new PhoneService());
		Endpoint.publish(address2, new PhoneService());
		System.out.println("wsdl地址1："+address1+"?WSDL");
		System.out.println("wsdl地址2："+address2+"?WSDL");

	}

}
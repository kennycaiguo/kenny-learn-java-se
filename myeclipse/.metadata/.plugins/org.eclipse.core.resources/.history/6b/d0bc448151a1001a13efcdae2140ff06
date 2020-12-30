package cn.kenny.ws.job;

import javax.xml.ws.Endpoint;

public class Test {

	public static void main(String[] args) {
		 JobService jobService=new JobServiceImpl();
		 String address="http://127.0.0.1:3333/ws/Jobservice";
		 Endpoint.publish(address, jobService);
		 System.out.println("wsdl地址："+address+"?WSDL");
	}

}

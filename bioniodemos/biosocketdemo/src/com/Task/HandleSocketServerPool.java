package com.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ����һ���̳߳���
 * @author Administrator
 *
 */
public class HandleSocketServerPool {
	//1.����һ���̳߳ر���
	private  ExecutorService excutorService;


	public HandleSocketServerPool() {
		 
	} 	
	//2.�ڹ��캯���г�ʼ���̳߳ر���
	public HandleSocketServerPool(int maxThreadNum,int  queueSize) {
		excutorService=new ThreadPoolExecutor(3, maxThreadNum, 120,
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
	} 
	
    //3.�ṩһ������������Ϊ�ύ���̳߳ص���������ݴ棬�ȴ��̳߳�������
	public void excute(Runnable target) {
		excutorService.execute(target);
	}
}

package com.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 这是一个线程池类
 * @author Administrator
 *
 */
public class HandleSocketServerPool {
	//1.创建一个线程池变量
	private  ExecutorService excutorService;


	public HandleSocketServerPool() {
		 
	} 	
	//2.在构造函数中初始化线程池变量
	public HandleSocketServerPool(int maxThreadNum,int  queueSize) {
		excutorService=new ThreadPoolExecutor(3, maxThreadNum, 120,
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
	} 
	
    //3.提供一个方法来将认为提交给线程池的任务队列暂存，等待线程池来处理
	public void excute(Runnable target) {
		excutorService.execute(target);
	}
}

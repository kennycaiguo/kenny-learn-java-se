package threadDemo;
/*
 * 创建线程方法2：
 * 1.创建一个实现Runnable接口的类
 * 2.写run()方法代码
 * 3.创建实现Runnable接口的类的对象
 * 4.创建一个Thread类的对象，并且接受实现Runnable接口的类的对象作为实参
 * 5.调用该对象的start()方法
 * 推荐这种方法
 * */
public class ThreadDemo2 implements Runnable{
	   
         public void run() {
        	 for(int i=1;i<20;i++) {
        		 System.out.println(Thread.currentThread().getName()+":"+i);
        	 }
        	
         }
         
         public static void main(String[] args) {
			ThreadDemo2 td= new ThreadDemo2();
			 ThreadDemo2 td2= new ThreadDemo2();
			 Thread t=new Thread(td,"pussy");
			 Thread t2=new Thread(td2,"breast");
			 t.start();
			 t2.start();
		}
}

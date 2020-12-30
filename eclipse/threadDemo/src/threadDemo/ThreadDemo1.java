package threadDemo;
/*
 * 创建线程方法1：
 * 1.创建一个Thread类的子类
 * 2.重写run()方法
 * 3.创建Thread类的子类的对象，并且调研start()方法，该方法会自动调用run()
 * 不推荐这种方法
 * */
public class ThreadDemo1 extends Thread{
	    public ThreadDemo1(String name) {
	    	super(name);
	    }
         public void run() {
        	 for(int i=1;i<20;i++) {
        		 System.out.println(Thread.currentThread().getName()+":"+i);
        	 }
        	
         }
         
         public static void main(String[] args) {
			ThreadDemo1 td= new ThreadDemo1("pussy");
			td.start();
			ThreadDemo1 td2= new ThreadDemo1("vagina");
			td2.start();
		}
}

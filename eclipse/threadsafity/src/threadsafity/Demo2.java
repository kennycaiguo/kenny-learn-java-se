package threadsafity;

public class Demo2 implements Runnable{
    public int num=50; //在这里不需要static因为后面的三个线程会共享同一个实现类的对象
	@Override
	public void run() {
		 while(true) {
			 synchronized("lock") {
				 if(num>0) {
					 System.out.println(Thread.currentThread().getName()+" Saling ticket no:"+num);
					 num--;
				 }
				 else {
					 System.out.println("Sold out!!!");
					 break;
				 }
					 
			 }
		 }
	}
    public static void main(String[] args) {
		Demo2 d =new Demo2();
		Thread th1=new Thread(d,"Mary");
		Thread th2=new Thread(d,"Janna");
		Thread th3=new Thread(d,"Lila");
		th1.start();
		th2.start();
		th3.start();
	}
}

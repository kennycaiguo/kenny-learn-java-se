package threadsafity;
/*
 * 解决线程安全问题的方法可以使用同步代码块和同步函数，推荐使用同步代码块
 * 同步代码块的用法：
 * synchronized("锁对象"){
 *   ....具体代码
 * }//"锁对象"可以是任何对象，包括用双引号括住的字符串
 * */
public class Demo1 extends Thread{
	public Demo1(String name) {
		super(name);
	}
	public static int num=50;
   public void run() {
	   while(true) {
		   synchronized("lock") {
			   if(num>0) {
					  System.out.println(currentThread().getName()+" selling ticket No:" +num);
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
	Demo1 d1=new Demo1("Maria");
	Demo1 d2=new Demo1("Marta");
	d1.start();
	d2.start();
 }
}

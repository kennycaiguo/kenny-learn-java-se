package threadcomunication;
/*
 *  该实例演示了wait()方法和notify()方法的使用
 *  期待的效果：生产一个消费一个
 * */
class Product{
	String name;
	double price;
	boolean flag=false;
}

class Producer extends Thread{
	Product p;
	 public Producer(Product p) {
		 this.p=p;
	 }
	public void run() {
		int i = 0;
		while(true) {
			synchronized(p) {
				if(p.flag==false) {
					if(i%2==0) {
						p.name ="Apple";
						p.price=5.0;	
					}else {
						p.name ="pear";
						p.price=7.0;	
					}
					System.out.println("Producer Producing: "+p.name +" price:"+p.price);
					p.flag=true;
					i++;	
					p.notify();//唤醒消费者去消费
				}
				else {
					  try {
						p.wait();
					} catch (InterruptedException e) {
						 
						e.printStackTrace();
					}
				}
			}
		
		}
	}
}

class Consumer extends Thread{
	Product p;
	 public Consumer(Product p) {
		 this.p=p;
	 }
	public void run() {
		while(true) {
			
			synchronized(p) {
				if(p.flag) {
					System.out.println("Consumer consuming: "+p.name +" price:"+p.price);
					p.flag=false;
					p.notify();//唤醒生产者去生产
				}else{
					try {
						p.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
		
	}
}
public class ThreadCommunication {
   public static void main(String[] args) {
	   Product p=new Product();
	   Producer pd=new Producer(p);
	   Consumer cm= new Consumer(p);
	   pd.start();
	   cm.start();
}
}

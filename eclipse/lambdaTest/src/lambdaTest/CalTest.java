package lambdaTest;

public class CalTest {
  public static void main(String[] args) {
	methodCal((x,y)-> x+y);
	methodIncrease(x->{++x;System.out.println(x);});
 }
  public static void methodCal(Calculator ca) {
	  int result;
	  result=ca.cal(100,200);
	  System.out.println(result);
  }
  
  public static void methodIncrease(SelfIncrease si) {
	  int i=10;
	  si.selfIncrease(i);
	  
  }
}

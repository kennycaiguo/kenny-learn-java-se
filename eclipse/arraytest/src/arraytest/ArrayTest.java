package arraytest;

public class ArrayTest {
	public static void main(String[] args) {
		int[] intarray = {10,12,15,30,35};
		System.out.println(intarray.length);
		for(int i=0;i<5;i++) {
			intarray[i]++;
		}
		System.out.println("++++++++++++++++++++++++++++++++");
		
		for(int i=0;i<5;i++) {
			System.out.println(intarray[i]);
			
		}
	}
    
}

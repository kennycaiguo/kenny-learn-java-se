package test;

import java.util.Scanner;

public class TestDemo {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Please Enter a number");
	  int num=sc.nextInt();
	  switch(num)
	  {
		  case 18:
		  System.out.println("You are very young");
		  break;
		  case 36:
			  System.out.println("You are middle age");
			  break;
		  case 50:
			  System.out.println("You are old");
			  break;
	  }
  }
}

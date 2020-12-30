package netedClasses;

public class NetedClasses {
   public static void main(String[] args) {
	   Person p =new Person();
	   p.age=18;
	   p.name ="jimmy";
	   p.sex ="male";
	   System.out.print(p.name + "r\n" + p.age+"\r\n" +p.sex);
   }
}

class Person{
	int age;
	String name;
	String sex;
	 
	 
}
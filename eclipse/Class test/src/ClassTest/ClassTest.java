package ClassTest;

public class ClassTest {
   public static void main(String[] args)
   {
	   Tiger t =new Tiger();
	   System.out.println("Tiger is Mammal:" + t.isMammal());
	   
   }
}

abstract class Animal {
	public boolean isMammal() 
	{
		return true;
	}
	
	public boolean isCarnivorous()
	{
		return true;
	}
	
	public abstract String Bark();
	
}

class Tiger extends Animal
{
	public String Bark() 
	{
		return("hengheng....");
	}
}

class Duck extends Animal
{
	public boolean isMammal() 
	{
		return false;
	}
	
	public boolean isCarnivorous()
	{
		return false;
	}
	
	public String Bark()
	{
		return("Ga Ga....");
	}
	
}
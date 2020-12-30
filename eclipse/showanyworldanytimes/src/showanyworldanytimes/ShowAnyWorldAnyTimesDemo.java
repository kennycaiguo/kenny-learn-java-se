package showanyworldanytimes;

public class ShowAnyWorldAnyTimesDemo {
    public static void main(String[] args) {
    	ShowAnyword("Fucking Vagina", 1,2,3);
	}
    
    public static void ShowAnyword(String content,int...ints) {
 	   for(int i : ints) {
 		   System.out.println(content);
 	   }
    }
}

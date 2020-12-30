package chartovalue;

public class CharToNum {
   public static void main(String[] args) {
	String ascii ="A";
	int i=Character.codePointAt(ascii, 0);
	System.out.println("Letter A to int is:" +i);
	System.out.println("=====================");
	int num=106;
	char[] ch=Character.toChars(num);
	System.out.println("The int 106 to letter is :"+new String(ch));
}
}

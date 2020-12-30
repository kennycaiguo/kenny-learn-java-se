package regExpress;

import java.util.Arrays;

/*
 * 正则表达式的用途：匹配，切割，替换，查找，这里演示替换
   
  预定义字符类 
. 任何一个字符（与行结束符可能匹配也可能不匹配） 
\d 数字：[0-9] 任意一个
\D 非数字： [^0-9] 
\s 空白字符：[ \t\n\x0B\f\r] 
\S 非空白字符：[^\s] 
\w 单词字符：[a-zA-Z_0-9] 
\W 非单词字符：[^\w] 

Greedy 数量词，控制贪婪匹配
X?       表示 X出现零次或一次 
X*       表示 X出现零次或多次 
X+      表示 X出现 一次或多次 
X{n}    表示 X刚好出现 n 次 
X{n,}   表示 X至少出现 n 次 
X{n,m} 表示 X至少出现 n 次 ,至多出现 m次 

  
POSIX 字符类（仅 US-ASCII） 

 * */
public class RegExpressDemo2_2 {
   public static void main(String[] args) {
	   replaceAllFound2();
	 
}
/*
 * public static void matchTel(String tel) {
 * 
 * System.out.println(tel.matches("0\\d{2,3}-[1-9]\\d{6,7}")?"正确电话号":"错误电话号"); }
 * }
 */
	/*
	 * public static void splitTest1() { String str="明    天   放  假";
	 * //此次的空格全都不一样不能使用str.split(" "); String[] strnew=str.split(" +");
	 * System.out.println(Arrays.toString(strnew)); } public static void
	 * splitTest2() { String str="大家家家明天天玩得得得得得得得得开心"; // String[]
	 * strnew=str.split("(.)\\1+"); //String[] strnew=str.split(".\\1+");这样子是不行的
	 * System.out.println(Arrays.toString(strnew)); }
	 */
   public static void replaceAllFound1() {
	   String str="如有需求，请联系我：13556081234.如有需求，请联系我：13556081234.如有需求，请联系我：13556081234." ;
       str=str.replaceAll("1[34578]\\d{9}", "****");
     System.out.println("替换后的字符串："+str);
   }
   public static void replaceAllFound2() {
	   String str="我我我要要要做做做项项项项项项目目" ;
	   str=str.replaceAll("(.)\\1+", "$1");//在正则表达式外面要用"$组号"的格式来引用正则表达式的组
	   System.out.println("替换后的字符串："+str);
   }
}
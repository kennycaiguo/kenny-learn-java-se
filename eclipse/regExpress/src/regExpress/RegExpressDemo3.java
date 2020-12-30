package regExpress;

import java.util.Arrays;

/*
 * 正则表达式的用途：匹配，切割，替换，查找，这里演示切割
  这个例子演示了用正则表达式来验证qq号码：
  1.qq号码不能以0开头
  2.qq号码长度是5-11位
  3.QQ号码必须全是数字
  正则表达式规则："[1-9]\\d{4,10}" 可以调研String类的matches方法
  
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
需求：用正则表达式匹配邮箱
 * */
public class RegExpressDemo3 {
   public static void main(String[] args) {
	 verifyEmail("kenny887@gmail.com");
	 
}
 
   public static void verifyEmail(String email) {
	   System.out.println(email.matches("([a-zA-Z1-9]+)@(.+)\\.(.+)")?"正确电子邮箱":"错误电子邮箱");
   }
   
}
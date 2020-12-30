package regExpress;

import java.util.Arrays;

/*
 * 正则表达式的用途：匹配，切割，替换，查找，这里演示查找
   这里不能使用字符串的方法，而要使用
   1.Pattern 匹配对象
   2.Matcher 匹配器对象
   
   
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
public class RegExpressDemo4 {
   public static void main(String[] args) {
	    
	 
  }
 
		   
}
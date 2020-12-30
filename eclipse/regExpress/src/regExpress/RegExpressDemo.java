package regExpress;
/*
 * 正则表达式的用途：匹配，切割，替换，查找，这里演示匹配
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

 * */
public class RegExpressDemo {
   public static void main(String[] args) {
	//String qq="123"; //非法qq
	   //String qq="123a123";//非法qq
	   //String qq="0123123";//非法qq
	   //String qq="123123";//合法qq
	   
	//System.out.println(qq.matches("[1-9]\\d{4,10}")? "合法qq":"非法qq");
	//System.out.println("任意字符："+("a".matches("."))); //true
	//System.out.println("任意字符："+("abc".matches("."))); //false
	
	   //System.out.println("0次或多次："+("bbbb".matches("\\w*"))); //true,0次或多次
	   //System.out.println("0次或多次："+("bbbb".matches("\\w+"))); //true,1次或多次
	   //System.out.println("1次或多次："+("b".matches("\\w+"))); //true,1次或多次
	//System.out.println("0次或多次："+("aaaa".matches("\\w*"))); //true,0次或多次
	//System.out.println("刚好3次："+("abc".matches("\\w{3}"))); //true,刚好3次
	//System.out.println("至少3次："+("abcdefg".matches("\\w{3,}"))); //true,至少3次
	  // System.out.println("3-7次："+("abcd".matches("\\w{3,7}"))); //true,3-7次
	   //System.out.println("3-7次："+("abcdfghij".matches("\\w{3,7}"))); //false，多于7次
	  // System.out.println("3-7次："+("ab".matches("\\w{3,7}"))); //false，少于3次
	
	//matchTel("0769-87716563");
	matchTel("010-87716563");
	
}
   public static void matchTel(String tel) {
	   
	   System.out.println(tel.matches("0\\d{2,3}-[1-9]\\d{6,7}")?"正确电话号":"错误电话号");
   }
}

# learn-java-se

java学习
# <a href="https://juejin.cn/post/6844904071145455624">13 个最火的 SpringBoot 实战开源项目推荐！总有一个适合你！</a>
# <a href="https://projects.eclipse.org/">Eclipse 开源项目</a>
# <a href="https://git.eclipse.org/c/?p=about">eclipse source code</a>
# <a href="https://github.com/kennycaiguo/play-samples">Java samples,java chatroom sample</a>
# <a href="https://github.com/kennycaiguo/ChatRoom-java">基于JAVA的即时通讯项目</a>
# <a href="https://github.com/kennycaiguo/javaWebChatroom">java网络聊天室，支持传图片，发表情，截图，群聊私聊功能。</a>
# <a href="https://github.com/kennycaiguo/java-wechat">A High Copy WeChat ,SNS APP (高仿微信)</a>
# <a href="https://github.com/kennycaiguo/YiChat">YiChat-基于tigase的独立IM系统</a>
# java 实现输入10进制数输出二进制数
import java.util.Scanner;

public class DectoBin {
    public static void main(String[] args) {

        System.out.println("请输入一个十进制整数：");

        DectoBin task = new DectoBin();
        int result = task.decimalConvertBinal();
        System.out.println("结果是：" + result);
    }

    private int decimalConvertBinal() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int i = 1;
        int result = 0;
        for (;;) {
            if (input == 0) {
                break;
            } else {
                int remain = input % 2;
                input = input / 2;
                result += remain * i;
                i = i * 10;
            }
        }
        return result;
    }

}

运行：请输入一个十进制整数：
8
结果是：1000

#  编程求：∑1+∑2+……+∑100的和
方法一：public class SegmaTotalTest {
    public static void main(String[] args) {
        SegmaTotalTest test = new SegmaTotalTest();
        int sum = test.SegmaTotal(100);
        System.out.println("∑1+∑2+……+∑100= " + sum);
    }

    int SegmaTotal(int n) {
        int sum = 0;
        for (int j = 0; j <= n; j++) {
            for (int i = 0; i <= j; i++) {
                sum += i;
            }
        }
        return sum;
    }
}

结果：171700

方法二：
public class SegmaTotalTest2 {
    public static void main(String[] args) {
        SegmaTotalTest2 test = new SegmaTotalTest2();
        int sum = test.SegmaTotal(100);
        System.out.println("∑1+∑2+……+∑100= " + sum);
    }

    int totalTon(int n) { //计算每一个∑n的结果
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    int SegmaTotal(int n) { //将所有∑n的结果加起来
        int segsum = 0;
        for (int j = 0; j <= n; j++) {
            segsum += totalTon(j);
        }
        return segsum;
    }
}
结果：171700

# java 在不知道有多少个对象的情况下，把所有的对象都读取进内存
//主程序
package org.kenny;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
 


public class TestDemo2 {

	public static void main(String[] args) throws IOException, Exception {
		 
		FileInputStream fis=new FileInputStream("stu.dat");
		ObjectInputStream ois=new ObjectInputStream(fis);
		try {
			while(true) {
			Student stu=(Student) ois.readObject();//这里不调用Student类的构造方法
			System.out.println(stu);
			}
		} catch (EOFException e) { //一定要在这里添加处理代码，否则程序运行的时候会出错
			// TODO Auto-generated catch block
			System.out.println("End of file");
		}
	}

}

//和主程序在同一个包下面的Student.java文件
package org.kenny;

import java.io.Serializable;

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5043645740290553040L;
	private String name;
	private String gender;
	private int age;
	private double score;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	public Student(String name, String gender, int age, double score) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.score = score;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student[name:"+this.name+",gender:"+this.gender+",age:"+this.age+",score:"+this.score+"]";
	}
}
 

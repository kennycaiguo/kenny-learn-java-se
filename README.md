# learn-java-se

java学习
# <a href="https://juejin.cn/post/6844904071145455624">13 个最火的 SpringBoot 实战开源项目推荐！总有一个适合你！</a>
# <a href="https://projects.eclipse.org/">Eclipse 开源项目</a>
# <a href="https://git.eclipse.org/c/?p=about">eclipse source code</a>
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



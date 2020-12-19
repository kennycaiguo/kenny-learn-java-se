# learn-java-se
java学习
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

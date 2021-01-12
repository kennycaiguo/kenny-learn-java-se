import java.util.Scanner;

public class ScannerEmailDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的邮箱：");
        if (sc.hasNext("\\w+@\\w+\\.\\w+")) {
            String value = sc.next("\\w+@\\w+\\.\\w+");
            System.out.println("email:" + value);
        } else {
            System.out.println("email 格式错误");
        }
    }
}

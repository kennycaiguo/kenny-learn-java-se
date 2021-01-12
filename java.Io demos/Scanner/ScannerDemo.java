import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入信息：");
        String str = sc.nextLine();
        System.out.println("你输入的是：" + str);
    }
}
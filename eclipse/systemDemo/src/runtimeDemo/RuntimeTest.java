package runtimeDemo;
/*  ava 带参调用notepad.exe
 *  Runtime rt= Runtime.getRuntime();
	//Process p =rt.exec("c:\\Windows\\notepad.exe");
	String[] cmd = {"c:\\Windows\\notepad.exe","e:\\test.txt"};
	Process p =rt.exec(cmd);
 * 
 */
import java.io.IOException;

public class RuntimeTest {
  public static void main(String[] args) throws IOException {
	Runtime rt= Runtime.getRuntime();
	//Process p =rt.exec("c:\\Windows\\notepad.exe");
	String[] cmd = {"c:\\Windows\\notepad.exe","e:\\test.txt"};
	Process p =rt.exec(cmd);
}
}

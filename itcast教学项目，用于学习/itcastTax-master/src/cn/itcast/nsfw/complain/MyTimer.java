package cn.itcast.nsfw.complain;

import java.util.Timer;

public class MyTimer {

	public static void main(String[] args) {
		Timer timer=new Timer();
		//延迟2秒执行，每三秒执行一次
		timer.schedule(new MyTimerTask(), 2000, 5000);
	}

}

package mythread2;

import otherObject.MyObject9;

//ͬ�������
public class MyThread7 extends Thread{
	
	private MyObject9 myObject9;
	
	public MyThread7(MyObject9 myObject9) {
		this.myObject9 = myObject9;
	}
	
	@Override
	public void run() {
		super.run();
		myObject9.method();
	}

}

package mythread1;

import otherObject.MyObject;

//synchronized������������
public class MyThread6 extends Thread{
	
	private MyObject myObject;
	
	public MyThread6(MyObject myObject) {
		this.myObject = myObject;
	}

	@Override
	public void run() {
		super.run();
		myObject.method1();
	}
	
}

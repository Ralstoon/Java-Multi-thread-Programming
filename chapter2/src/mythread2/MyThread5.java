package mythread2;

import otherObject.MyObject5;

//���������ĸ�����̳�
public class MyThread5 extends Thread {
	
	@Override
	public void run() {
		MyObject5 myObject5 = new MyObject5();
		myObject5.methodSon();
	}

}

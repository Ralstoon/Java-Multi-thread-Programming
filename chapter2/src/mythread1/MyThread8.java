package mythread1;

import otherObject.MyObject2;

//��һ������һ����ͬ��������һ������ͬ������
public class MyThread8 extends Thread {

	private MyObject2 myObject2;
	
	public MyThread8(MyObject2 myObject2) {
		this.myObject2 = myObject2;
	}
	
	@Override
	public void run() {
		super.run();
		myObject2.method1();//method1��ͬ������
	}
}

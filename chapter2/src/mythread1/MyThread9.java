package mythread1;

import otherObject.MyObject2;

//��һ������һ����ͬ��������һ������ͬ������
public class MyThread9 extends Thread {

	private MyObject2 myObject2;
	
	public MyThread9(MyObject2 myObject2) {
		this.myObject2 = myObject2;
	}
	
	@Override
	public void run() {
		super.run();
		myObject2.mehtod2();//mehtod2�Ƿ�ͬ������
	}
}

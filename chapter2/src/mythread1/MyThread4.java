package mythread1;

import otherObject.HasPrivateNum;

//ʵ�������ķ��̰߳�ȫ
public class MyThread4 extends Thread {
	
	private HasPrivateNum hasPrivateNum;
	
	public MyThread4(HasPrivateNum hasPrivateNum) {
		this.hasPrivateNum = hasPrivateNum;
	}

	
	@Override
	public void run() {
		hasPrivateNum.addUsername("a");
	}
	
}

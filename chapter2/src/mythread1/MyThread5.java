package mythread1;

import otherObject.HasPrivateNum;

//ʵ�������ķ��̰߳�ȫ
public class MyThread5 extends Thread {
	
	private HasPrivateNum hasPrivateNum;
	
	public MyThread5(HasPrivateNum hasPrivateNum) {
		this.hasPrivateNum = hasPrivateNum;
	}

	
	@Override
	public void run() {
		hasPrivateNum.addUsername("b");
	}
	
}

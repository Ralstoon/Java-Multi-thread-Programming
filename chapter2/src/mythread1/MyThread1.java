package mythread1;

import otherObject.HasSelfPrivateNum;

//�����ڲ�����һ���������ǲ�����"���̰߳�ȫ"�����
public class MyThread1 extends Thread{
	
	private HasSelfPrivateNum hasSelfPrivateNum;
	
	public MyThread1(HasSelfPrivateNum hasSelfPrivateNum) {
		this.hasSelfPrivateNum = hasSelfPrivateNum;
	}

	@Override
	public void run() {
		super.run();
		hasSelfPrivateNum.addI("a");
	}
	
}

package mythread1;

import otherObject.HasSelfPrivateNum;

//�����ڲ�����һ���������ǲ�����"���̰߳�ȫ"�����
public class MyThread2 extends Thread{
	
	private HasSelfPrivateNum hasSelfPrivateNum;
	
	public MyThread2(HasSelfPrivateNum hasSelfPrivateNum) {
		this.hasSelfPrivateNum = hasSelfPrivateNum;
	}

	@Override
	public void run() {
		super.run();
		hasSelfPrivateNum.addI("b");
	}
	
}

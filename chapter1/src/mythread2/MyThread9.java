package mythread2;

//�߳�ֹͣ(ִ����interrupt����),��ִ��sleep����
public class MyThread9 extends Thread{
	
	@Override
	public void run() {
		super.run();
		try {
			System.out.println("run������ʼ");
			Thread.sleep(1000);
			System.out.println("run��������");
		} catch (InterruptedException e) {
			System.out.println("�������쳣�����");
			e.printStackTrace();
		}
	}

}

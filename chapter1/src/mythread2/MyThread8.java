package mythread2;

//�ڳ�˯��ֹͣ
public class MyThread8 extends Thread {
	
	@Override
	public void run() {
		super.run();
		try {
			System.out.println("run��ʼ");
			Thread.sleep(200000);
			System.out.println("run����");
		} catch (InterruptedException e) {
			System.out.println("�ڳ�˯�б�ֹͣ�ˣ�����catch	" + this.isInterrupted());
			e.printStackTrace();
		}
	}
	
}

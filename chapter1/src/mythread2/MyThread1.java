package mythread2;

//�жϵ�ǰ���߳��Ƿ��ڻ��״̬
public class MyThread1 extends Thread {

	@Override
	public void run() {
		System.out.println("run=" + this.isAlive());
	}
}

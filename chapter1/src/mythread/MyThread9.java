package mythread;

//currentThread()����
public class MyThread9 extends Thread {
	
	public MyThread9() {
		System.out.println("���췽����ӡ���߳���" + Thread.currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println("run������ӡ���߳���" + Thread.currentThread().getName());
	}
}

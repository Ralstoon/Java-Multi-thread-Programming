package mythread2;

//������̶߳����Թ�������ķ�ʽ���ݸ�Thread���󣬽���strat()����ʱ
public class MyThread2 extends Thread{

	public MyThread2() {
		System.out.println("��������ʼ");
		System.out.println("Thread���߳�����" + Thread.currentThread().getName());
		System.out.println("Thread�߳��Ƿ��Ծ" + Thread.currentThread().isAlive());
		System.out.println("this�̵߳�����" + this.getName());
		System.out.println("this�߳��Ƿ��Ծ" + this.isAlive());
		System.out.println("����������");
	}
	
	@Override
	public void run() {
		System.out.println("run������ʼ");
		System.out.println("Thread���߳�����" + Thread.currentThread().getName());
		System.out.println("Thread�߳��Ƿ��Ծ" + Thread.currentThread().isAlive());
		System.out.println("this�̵߳�����" + this.getName());
		System.out.println("this�߳��Ƿ��Ծ" + this.isAlive());
		System.out.println("run����");
	}
	
	
}

package mythread3;

//�̵߳����ȼ�
public class MyThread9 extends Thread {
	
	@Override
	public void run() {
		System.out.println("thread1���߳�" + this.getPriority());
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				System.out.println("thread2���߳�" + this.getPriority());
			}
		};
		thread2.start();
	}
}

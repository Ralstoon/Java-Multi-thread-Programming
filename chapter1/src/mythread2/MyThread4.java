package mythread2;

//sleep()����(2)
public class MyThread4 extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("run��this�߳̿�ʼ" + this.currentThread().getName() + System.currentTimeMillis());
			System.out.println("Thread���߳���" + Thread.currentThread().getName());
			System.out.println("run��this�߳̽���" + this.currentThread().getName() + System.currentTimeMillis());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

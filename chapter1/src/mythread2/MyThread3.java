package mythread2;

//sleep()����(1)
public class MyThread3 extends Thread{
	
	@Override
	public void run() {
		try {
			System.out.println("run������this�߳�" + this.currentThread().getName()+ "��ʼ");
			Thread.sleep(2000);
			System.out.println("run������this�߳�" + this.currentThread().getName()+ "����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

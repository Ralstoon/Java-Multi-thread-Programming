package mythread1;

public class MythreadB extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			System.out.println("�߳�B��ʼ");
			Thread.sleep(3000);
			System.out.println("�߳�B����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public void methodA(){
		System.out.println("methodA����ִ����");
	}
	
}

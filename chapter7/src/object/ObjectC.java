package object;

//�߳���
public class ObjectC extends Thread {
	
	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("�߳�����" + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

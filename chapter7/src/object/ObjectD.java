package object;

public class ObjectD extends Thread {
	
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("�߳�������" + Thread.currentThread().getName());
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
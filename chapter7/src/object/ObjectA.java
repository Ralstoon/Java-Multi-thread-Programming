package object;

public class ObjectA extends Thread {
	
	public ObjectA() {
		System.out.println("���췽����״̬" + Thread.currentThread().getState());
	}
	
	public void run() {
		System.out.println("run������״̬" + Thread.currentThread().getState());
	}
	
}


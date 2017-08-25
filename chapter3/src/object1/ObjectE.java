package object1;

//������
public class ObjectE{
	
	private String lock;
	
	public ObjectE(String lock) {
		this.lock = lock;
	}
	
	public void getValue() {
		synchronized (lock) {
			try {
				if (ObjectD.VALUE.equals("")) {
//					System.out.println("wait_get");
					lock.wait();
				}
				System.out.println("get��ֵ��" + ObjectD.VALUE);
				ObjectD.VALUE = "";
				lock.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

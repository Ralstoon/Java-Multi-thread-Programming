package object1;

//�������������:����ֵ-����
public class ObjectG {

	private String lock;
	
	public ObjectG(String lock) {
		this.lock = lock;
	}
	
	public void geValue(){
		try {
			synchronized (lock) {
				while (ObjectD.VALUE.equals("")) {
					System.out.println("������" + Thread.currentThread().getName() + "�߳�" + "waiting�ˡ��");
					lock.wait();
				}
				System.out.println("������" + Thread.currentThread().getName() + "�߳�" + "running��");
				
				ObjectD.VALUE = "";
				lock.notify();
//				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

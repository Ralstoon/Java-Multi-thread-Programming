package object1;

//�������������:����ֵ-����
public class ObjectF {
	
	 private String lock;
	 
	 public ObjectF(String lock) {
		 this.lock = lock;
	 }
	 
	 public void setValue(){
		  try {
			synchronized (lock) {
				  while (!ObjectD.VALUE.equals("")) {
					  System.out.println("������" + Thread.currentThread().getName() + "�߳�" + "waiting�ˡ�");
					  lock.wait();
				}
				System.out.println("������" + Thread.currentThread().getName() + "�߳�" + "running��");
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				ObjectD.VALUE = value;
				lock.notify();
//				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	 
}

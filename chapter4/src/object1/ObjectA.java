package object1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectA {
	
	private Lock lock = new ReentrantLock();
	
	public void methodA(){
		lock.lock();
		for (int i = 0; i < 5; i++) {
			System.out.println("��ǰ�߳���" + Thread.currentThread().getName() + "��ӡ��ֵ��" + i);
		}
		lock.unlock();
	}
	
}

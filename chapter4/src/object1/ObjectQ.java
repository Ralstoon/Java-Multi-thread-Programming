package object1;

import java.util.concurrent.locks.ReentrantLock;

//�����ǲ�ѯ�������ǲ�����������̱߳���
public class ObjectQ {

	private ReentrantLock lock ;
	
	public ObjectQ(boolean isFair) {
		lock = new ReentrantLock(isFair);
	}
	
	public void methodA(){
		try {
			System.out.println("�����ǲ�����������̱߳���" + lock.isLocked());
			lock.lock();
			System.out.println("�����ǲ�����������̱߳���" + lock.isLocked());
		} finally {
			lock.unlock();
		}
	}
}

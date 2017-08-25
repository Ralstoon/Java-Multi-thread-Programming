package object1;

import java.util.concurrent.locks.ReentrantLock;

public class ObjectO {

	private ReentrantLock lock;
	
	//�����������ǲ��ǹ�ƽ��
	public ObjectO(boolean isFair) {
		lock = new ReentrantLock(isFair);
	}
	
	public void methodA(){
		try {
			lock.lock();
			System.out.println("���Ĺ�ƽ���" + lock.isFair());
		} finally {
			lock.unlock();
		}
		
	}
	
}

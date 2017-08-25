package object1;

import java.util.concurrent.locks.ReentrantLock;

//��ƽ��
public class ObjectI {
	
	private ReentrantLock lock;
	
	public ObjectI(boolean isFair) {
		//�����Ƿ��ǹ�ƽ��
		lock = new ReentrantLock(isFair);
	}	
	
	public void methodA(){
		try {
			lock.lock();
			System.out.println("�̵߳�������" + Thread.currentThread().getName() + "�����");
		}finally {
			lock.unlock();
		}
	}
}

package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectC {

	private Lock lock = new ReentrantLock();

	//ʹ��ReentrantLockҲ����ʵ��ͬ���Ĺ��ܣ�����Ҫ����Condition����
	private Condition condition = lock.newCondition();
	
	public void await(){
		try {
			lock.lock();
			System.out.println("A");
			condition.await();
			System.out.println("B");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
			System.out.println("���ͷ���");
		}
	}
}

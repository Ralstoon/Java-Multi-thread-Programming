package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectN  {
	
	private ReentrantLock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	public void waitMethod(){
		try {
			lock.lock();
			condition.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
	public void notityMethod(){
		try {
			lock.lock();
			System.out.println("��û���߳����ڵȴ�condition" + "  " + lock.hasWaiters(condition) + "�̵߳ĸ����Ƕ���" + lock.getWaitQueueLength(condition));
			condition.signalAll();
			System.out.println("��û���߳����ڵȴ�condition" + "  " + lock.hasWaiters(condition) + "�̵߳ĸ����Ƕ���" + lock.getWaitQueueLength(condition));

		}finally {
			
			lock.unlock();
		}
	}
	
}

package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectT {

	private ReentrantLock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	public void waitMethod(){
		try {
			lock.lock();
			System.out.println("await֮ǰ");
			condition.await();
			//ִ�д�����ͽ��뵽������״̬��ֻ�б����Ѻ�Ż��������µĴ���
			System.out.println("await֮��");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void waitMethodA(){
		try {
			lock.lock();
			System.out.println("await֮ǰ");
			condition.awaitUninterruptibly();
			System.out.println("await֮��");
		} finally {
			lock.unlock();
		}
	}
	
}

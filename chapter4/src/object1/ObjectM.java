package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectM  {

	public ReentrantLock lock = new ReentrantLock();
	
	public Condition condition = lock.newCondition();//Condition()�������ֻҪ������ʵ�ֵȴ���֪ͨ�Ļ��Ƶ�
	
	public void waitMethod(){
		try {
			lock.lock();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
}

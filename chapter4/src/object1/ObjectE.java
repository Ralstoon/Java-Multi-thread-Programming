package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ʹ�ö��Conditionʵ��֪ͨ�����߳�:������÷�
public class ObjectE{
	
	private Lock lock = new ReentrantLock();
	
	public Condition condition = lock.newCondition();
	
	public void awaitA(){
		try {
			lock.lock();
			System.out.println("awaitA��ʼ��ʱ����" + System.currentTimeMillis() + "��ǰ���߳���" + Thread.currentThread().getName());
			condition.await();
			System.out.println("awaitA������ʱ����" + System.currentTimeMillis() + "��ǰ���߳���" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	
	public void awaitB(){
		try {
			lock.lock();
			System.out.println("awaitB��ʼ��ʱ����" + System.currentTimeMillis() + "��ǰ���߳���" + Thread.currentThread().getName());
			condition.await();
			System.out.println("awaitB������ʱ����" + System.currentTimeMillis() + "��ǰ���߳���" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void signalAll(){
		try{
			lock.lock();
			System.out.println("signalAll��ʱ����" + System.currentTimeMillis() + "��ǰ�߳���" + Thread.currentThread().getName());
			condition.signalAll();
		} finally {
			lock.unlock();
		}
		
	}
	
}

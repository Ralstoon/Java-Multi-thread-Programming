package object1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ʹ�ö��Conditionʵ��֪ͨ�����߳�:��ȷ���÷�
public class ObjectF {
	
	private Lock lock = new ReentrantLock();
	
	public Condition conditionA = lock.newCondition();
	public Condition conditionB = lock.newCondition();
	
	public void awaitA(){
		try {
			lock.lock();
			System.out.println("awaitA��ʼ" + "��ǰ���߳���" + Thread.currentThread().getName());
			conditionA.await();
			System.out.println("awaitA����" + "��ǰ���߳���" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	
	public void awaitB(){
		try {
			lock.lock();
			System.out.println("awaitA��ʼ" + "��ǰ���߳���" + Thread.currentThread().getName());
			conditionB.await();
			System.out.println("awaitA����" + "��ǰ���߳���" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void signalAll_A(){
		try {
			lock.lock();
			System.out.println("signalAll_A��ʼ" + "��ǰ���߳���" + Thread.currentThread().getName());
			conditionA.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	
	public void signalAll_B(){
		try {
			lock.lock();
			System.out.println("signalAll_B" + "��ǰ���߳���" + Thread.currentThread().getName());
			conditionB.signalAll();
		} finally {
			lock.unlock();
		}
		
	}
	
}

package object1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectB {
	
	private Lock lock = new ReentrantLock();
	
	public void methodA(){
		try {
			lock.lock();
			System.out.println("����A��ʼ" + "��ǰ�߳���" + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("����A����" + "��ǰ�߳���" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			lock.unlock();
		}
	}
	
	public void methodB(){
		try {
			lock.lock();
			System.out.println("����B��ʼ" + "��ǰ�߳���" + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("����B����" + "��ǰ�߳���" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			//������ǵ�Ҫ�ͷ���
			lock.unlock();
		}
	}
	
	
}

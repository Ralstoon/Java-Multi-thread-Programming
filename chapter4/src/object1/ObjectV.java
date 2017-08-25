package object1;

import java.util.concurrent.locks.ReentrantReadWriteLock;
//д��
public class ObjectV {
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void write(){
		try {
			lock.writeLock().lock();
			System.out.println("��ȡд��" + Thread.currentThread().getName());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}

}

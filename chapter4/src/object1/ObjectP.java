package object1;

import java.util.concurrent.locks.ReentrantLock;

//��ѯ��ǰ���߳��ǲ��Ǳ��ִ�����
public class ObjectP {

	private ReentrantLock lock;
	
	public ObjectP(boolean isFair) {
		lock = new ReentrantLock(isFair);
	}
	
	public void method(){
		try {
			System.out.println("���߳��ǲ��������˴�����������δ����֮ǰ" + lock.isHeldByCurrentThread());
			lock.lock();
			System.out.println("���߳��ǲ��������˴���,����������֮���" + lock.isHeldByCurrentThread());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}

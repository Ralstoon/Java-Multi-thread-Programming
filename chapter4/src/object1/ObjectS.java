package object1;

import java.util.concurrent.locks.ReentrantLock;

//tryLock():���þ��ǽ��ڵ��õ�������δ����һ���̱߳��ֵ�����£��Ż�ȡ������
public class ObjectS {
	
	public ReentrantLock lock = new ReentrantLock();
	
	public void waitMethod(){
		if (lock.tryLock()) {
			System.out.println("�߳�" + Thread.currentThread().getName() + "��ȡ��");
		}else {
			System.out.println("�߳�" + Thread.currentThread().getName() + "û�л�ȡ��");
		}
	}

}

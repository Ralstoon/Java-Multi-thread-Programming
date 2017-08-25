package test;

import object.ObjectA;
import object.ObjectB;
import object.ObjectC;
import object.ObjectD;

import org.junit.Test;

public class Test1 {
	
	
	/*
	 * -
	 * �̵߳�״̬:
	 * 	�̶߳����ڲ�ͬ������ʱ���в�ͬ��״̬��״̬��Ϣ�ʹ�����Stateö������
	 * 		Thread.State  �м���ֵ:NEW,RUNNABLE,BLOCKED,WAITING,TIMED_WAITING,TERMINATED
	 * 
	 */
	
	
	
	//�̵߳�״̬:��֤:new��runnable��terminated(����)
	@Test
	public void state() throws InterruptedException{
		ObjectA t1 = new ObjectA();
		System.out.println("main�����е�״̬1" + t1.getState());//����new��һ���̵߳��ǻ�û���������̵߳�״̬����new
		Thread.sleep(500);
		t1.start();
		Thread.sleep(500);
		System.out.println("main�����е�״̬2" + t1.getState());//�߳��Ѿ������н����ˣ����Ը��̵߳�״̬��terminated
	}
	
	
	//��֤timed_waiting:�̵߳�״̬timed_waiting��ʾ�߳�ִ����Thread.sleep()�������ʵȴ�״̬���ȴ�ʱ�䵽�ˣ�������������
	@Test
	public void timed_waiting() throws InterruptedException{
		Thread thread = new Thread(){
			public void run() {
				try {
					System.out.println("��ʼ˯��");
					Thread.sleep(5000);
					System.out.println("����˯��");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		Thread.sleep(1000);
		System.out.println("main�����ܵ�״̬��" + thread.getState());
	}
	
	
	//��֤blocked:������ĳһ���߳��ڵȴ�����ʱ��
	@Test
	public void blocked() throws InterruptedException{
		final ObjectB objectB = new ObjectB();
		Thread thread1 = new Thread(){
			public void run() {
				objectB.methodA();
			}
		};
		thread1.start();
		Thread.sleep(50);
		Thread thread2 = new Thread(){
			public void run() {
				objectB.methodA();
			}
		};
		thread2.start();
		Thread.sleep(50);
		System.out.println("main������thread2��״̬" + thread2.getState());
		/*
		 * �߳�thread1�Ѿ�������ͬ�������ˣ��߳�thread2�ȴ�����ͬ����������ʱ���̵߳�״̬����BLOCKED
		 */
	}
	
	
	
	//��֤WAITING:���߳�ִ��wait()������������״̬
	@Test
	public void WAITING() throws InterruptedException{
		Thread thread = new Thread(){
			public void run() {
				synchronized ("��") {
					try {
						"��".wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
		Thread.sleep(50);
		System.out.println("main�����е��߳�thread��״̬��" + thread.getState());
	}
	
	
	
	
	/*
	 * �߳���:���԰��̹߳�����ĳһ���߳����У��߳����п������̶߳���Ҳ�������߳��飬���л��������߳�
	 * 		���ã��������������̻߳��߳��������Ч�ض��̻߳��߳�����������֯
	 */
	 
	//�̶߳�������߳���:1������
	@Test
	public void threadArray() throws InterruptedException{
		ObjectC objectC = new ObjectC();
		ObjectD objectD = new ObjectD();
		ThreadGroup threadGroup = new ThreadGroup("Ī�������߳���");
		Thread thread = new Thread(threadGroup,objectC);
		Thread thread2 = new Thread(threadGroup,objectD);
		thread.start();
		thread2.start();
		Thread.sleep(3000);
		System.out.println("����߳�����" + threadGroup.activeCount());
		System.out.println("�߳����������" + threadGroup.getName());
		Thread.sleep(5000);
		/*
		 * ����̨��ӡ����Ϣ��ʾ�߳��������������̣߳����Ҵ�ӡ�����߳��������
		 */
	}
	
	
	
	//�߳����Զ���������:�Զ����������Զ��鵽��ǰ���߳�����

	
	/*
	 * SimpleDateFormat�̰߳�ȫ
	 * 	��Ҫ�Ǹ������ڵ�ת�����ʽ�������ڶ��̵߳Ļ����У�ʹ�ô��������������ת��������Ĳ�׼ȷ
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
 
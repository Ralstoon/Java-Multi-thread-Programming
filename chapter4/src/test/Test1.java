package test;

import java.util.concurrent.locks.ReentrantLock;

import object1.ObjectA;
import object1.ObjectB;
import object1.ObjectC;
import object1.ObjectD;
import object1.ObjectE;
import object1.ObjectF;
import object1.ObjectG;
import object1.ObjectH;
import object1.ObjectI;
import object1.ObjectJ;
import object1.ObjectK;
import object1.ObjectL;

import org.junit.Test;

//Lock��ʹ��
public class Test1 {

	//ʹ��ReentrantLockʵ��ͬ��:����һ
	@Test
	public void reentrantLockTest(){
		final ObjectA objectA = new ObjectA();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectA.methodA();
			}
		};
		thread.setName("A");
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectA.methodA();
			}
		};
		thread2.setName("B");
		
		
		Thread thread3 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectA.methodA();
			}
		};
		thread3.setName("C");
		
		thread.start();
		thread2.start();
		thread3.start();
		/*
		 * �����еĽ����������ǰ�̴߳�ӡ���֮���������ͷţ������̲߳ſ��Լ�����ӡ��
		 * 	�̴߳�ӡ�������Ƿ����ӡ�ģ���Ϊ��ǰ�߳��Ѿ��������ˣ����߳�֮��Ĵ�ӡ˳���������
		 * 
		 */
	}
	
	
	
	//ʹ��ReentrantLockʵ��ͬ��:���Զ�
	@Test
	public void reentrantLockTest2() throws InterruptedException{
		final ObjectB objectB = new ObjectB();
		final ObjectC objectC = new ObjectC();
		
		Thread thread = new Thread(){
			@Override
			public void run() {
				objectB.methodA();
			}
		};
		thread.setName("A");
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				objectB.methodA();
			}
		};
		thread2.setName("B");
		
		Thread thread3 = new Thread(){
			@Override
			public void run() {
				objectB.methodB();
			}
		};
		thread3.setName("C");
		
		Thread thread4 = new Thread(){
			@Override
			public void run() {
				objectB.methodB();
			}
		};
		thread4.setName("D");

		thread.start();
		thread2.start();
		Thread.sleep(1000);
		thread3.start();
		thread4.start();
		
		Thread.sleep(10000);
	}
	
	
	//ʹ��Conditionʵ�ֵȴ�/֪ͨ:�����÷���������jdk5�г��ֵļ���
	@Test
	public void useConditionWaitNotifyError(){
		final ObjectC objectC = new ObjectC();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectC.await();
			}
		};
		thread.start();
		/*
		 * 
		 * ʹ��condition.await()��������֮ǰ����Ҫ����lock.lock()�����ȡͬ��������������ͻ��׳��쳣
		 * 		����condition.await()����ʹ��ǰִ������idea�߳̽�����waiting״̬
		 * 
		 */
	}
	
	
	//��ȷʹ��Conditionʵ�ֵȴ�/֪ͨ
	@Test
	public void useConditionWaitNotifyOk() throws InterruptedException{
		final ObjectD objectD = new ObjectD();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectD.await();
			}
		};
		thread.start();
		Thread.sleep(3000);
		objectD.signal();
		/*
		 * �ɹ�ʵ�ֵȴ���֪ͨ�Ļ���
		 * 	Object���е�wait()�����൱��Condition���е�await()����
		 * 	Object���е�wait(long timeout)�����൱��Condition���е�await(long time,TimeUnit unit)����
		 * 	Object���е�notify()�����൱��Condition���е�signal()����
		 * 	Object���е�notifyAll()�����൱��Condition���е�signal()����
		 * 
		 * 	����signal()����֮ǰҲ��Ҫ����ͬ����
		 */
	}
	
	
	
	//ʹ�ö��Conditionʵ��֪ͨ�����߳�:������÷�
	@Test
	public void mustUseMoreCondition_error() throws InterruptedException{
		final ObjectE objectE = new ObjectE();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectE.awaitA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectE.awaitB();
			}
		};
		thread2.setName("B");
		
		thread.start();
		thread2.start();
		
		Thread.sleep(3000);
		
		objectE.signalAll();
		/*
		 * �������к��߳�A���߳�B����������
		 * 	�����Ҫ�������Ѳ����̸߳���ô������ʱ���б�Ҫʹ�ö��Condition�����ˣ�
		 * 		Ҳ����Conditionn������Ի��Ѳ���ָ���̣߳��������������������Ч�ʡ�
		 * 
		 */
	}
	
	
	
	//ʹ�ö��Conditionʵ��֪ͨ�����߳�:��ȷ���÷�
	@Test
	public void mustUseMoreCondition_OK() throws InterruptedException{
		final ObjectF objectF = new ObjectF();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectF.awaitA();
			}
		};
		thread.setName("A");
	
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectF.awaitB();
			}
		};
		thread2.setName("B");
		
		thread.start();
		thread2.start();
		
		Thread.sleep(3000);
		
		objectF.signalAll_A();
		/*
		 * 	�������к�ֻ���߳�A��������
		 * 		ͨ�����ʵ����Ե�֪��ʹ��ReentrantLock������Ի���ָ��������̣߳����ǿ��Ʋ����߳���Ϊ�ķ��㷽ʽ
		 */
	}
	
	
	
	//ʵ��������/������ģʽ:һ��һ�����ӡ
	@Test
	public void conditionTest(){
		final ObjectG objectG = new ObjectG();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		};
	}
	
	
	
	//ʵ��������/������ģʽ:��Զཻ���ӡ
	@Test
	public void conditionTestManyToMany() throws InterruptedException{
		final ObjectH objectH = new ObjectH();
		Thread[] threadA = new Thread[1000];
		Thread[] threadB = new Thread[1000];
		for (int i = 0; i < 1000; i++) {
			threadA[i] = new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					objectH.set();
				}
			};
			threadB[i] = new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					objectH.get();
				}
			};
			threadA[i].start();
			threadB[i].start();
		}
		Thread.sleep(2000);
		/*
		 * ������
		 * 
		 */
	}
	
	
	//��ƽ����ǹ�ƽ��
	@Test
	public void fair_noFair(){
		final ObjectI objectI = new ObjectI(true);//����������Ϊfalse���Ƿǹ�ƽ��
		Runnable runnable = new Runnable(){
			@Override
			public void run() {
				System.out.println("�߳�������" + Thread.currentThread().getName());
				objectI.methodA();
			}
		};
		
		Thread[] thread = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(runnable);
		}
		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}
		/*
		 *	��ƽ����ǹ�ƽ��:��Lock��Ϊ"��ƽ��"��"�ǹ�ƽ��"����ƽ����ʾ��ȡ����˳���ǰ����̼߳��ص�˳���������
		 *		�������ȵá�
		 *	���ǹ�ƽ����������� 	lock = new ReentrantLock(true/false);/true���ǹ�ƽ����false���Ƿǹ�ƽ��
		 * 
		 */
	}
	
	
	
	//����int getHoldCount():���ֲ�ѯ��ǰ�̱߳��ִ������ĸ�����Ҳ���ǵ���lock()�����Ĵ���
	@Test
	public void getHoldCount(){
		ObjectJ objectJ = new ObjectJ();
		objectJ.methodA();
	}
	
	
	//����int getQueueLength():�������ȴ���ȡ�������̹߳�����
	@Test
	public void getQueueLength() throws InterruptedException{
		final ObjectK objectK = new ObjectK();
		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threadArray[i] = new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					objectK.methodA();
				}
			};
		}
		for (int i = 0; i < 10; i++) {
			threadArray[i].start();
		}
		Thread.sleep(500);
		System.out.println("��ǰ��Ҫ��ȡ�����̸߳�����" + objectK.lock.getQueueLength());
		
	}
	
	
	//����int getWaitQueueLength(Condition condition) �������Ƿ��صȴ������������������Condition���̵߳Ĺ�����
	@Test
	public void getWaitQueueLength() throws InterruptedException{
		final ObjectL objectL = new ObjectL();
		Runnable runnable = new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				objectL.await();
			}
		};
		Thread[] thread = new Thread[10];
		
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(runnable);
		}
		
		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}
		
		Thread.sleep(1000);
		objectL.notityMethod();
		
	}
	
		
	
	
	
	
}
 
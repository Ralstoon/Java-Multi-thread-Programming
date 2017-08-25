package test;

import object1.ObjectM;
import object1.ObjectN;
import object1.ObjectO;
import object1.ObjectP;
import object1.ObjectQ;
import object1.ObjectR;
import object1.ObjectS;
import object1.ObjectT;

import org.junit.Test;

public class Test2 {

	//����boolean hasQueuedThread(Thread thread):�������ǲ�ѯָ���߳��Ƿ����ڵȴ���ȡ����
	@Test
	public void hasQueuedThread() throws InterruptedException{
		final ObjectM objectM = new ObjectM();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				objectM.waitMethod();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		Thread.sleep(500);
		
		Thread thread2 = new Thread(runnable);
		thread2.start();
		Thread.sleep(500);
		
		System.out.println(objectM.lock.hasQueuedThread(thread));//thread�Ƿ��ڵȴ��������thread�Ѿ��õ��˸��� �����Բ����ڵȴ�
		System.out.println(objectM.lock.hasQueuedThread(thread2));//�����Ѿ����߳�thread�õ��ˣ�thread2�����ڵȴ��������������true
		System.out.println(objectM.lock.hasQueuedThreads());//������һ����Ҳ���ڵȴ�thread�õ����ǰ���
	}
	
	
	//����boolean hasWaiters(Condition condition):�����ǲ�ѯ�Ƿ����߳����ڵȴ�������йص�condition����
	@Test
	public void hasWaiters() throws InterruptedException{
		final ObjectN objectN = new ObjectN();
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				objectN.waitMethod();
			}
		};
		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threadArray[i] = new Thread(runnable);
		}
		for (int i = 0; i < 10; i++) {
			threadArray[i].start();
		}
		Thread.sleep(1000);
		objectN.notityMethod();
		/*
		 * ��һ������������̶߳��ڵȴ�����Ϊʮ���̶߳������˶�ִ����condition.await();��һ�д��룬����ʮ���̶߳��ڵȴ���
		 * 	�ڶ������Ϊ������Ϊִ����condition.signalAll();��һ�д��룬�����̶߳��������ˣ���û�����ڵȴ���condition
		 */
	}
	
	
	//����boolean isFair():�������ж��ǲ��ǹ�ƽ��
	@Test
	public void isFair(){
		final ObjectO objectO = new ObjectO(true);//������Խ����Ĺ�ƽ�Ը�Ϊfalse
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				objectO.methodA();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		/*
		 * ��Ĭ�ϵ�����¡�ReentreantLock��ʹ�õ��ǹ�ƽ��
		 */
	}
	
	
	//����boolean isHeldByCurrentThread():�����ǲ�ѯ��ǰ���߳��ǲ��Ǳ��ִ�����
	@Test
	public void isHeldByCurrentThread(){
		final ObjectP objectP = new ObjectP(true);
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectP.method();
			}
		};
		thread.start();
	}
	
	
	//����boolean isLocked()�������ǲ�ѯ�������Ƿ��������̱߳���
	@Test
	public void isLockes(){
		final ObjectQ objectQ = new ObjectQ(true);
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectQ.methodA();
			}
		};
		thread.start();
	}
	
	
	//����lockInterruptibly():�����ǰ�߳�δ���жϣ����ȡ����������Ѿ����ж�������쳣
	@Test
	public void lockInterruptibly() throws InterruptedException{
		final ObjectR objectR = new ObjectR();
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				objectR.waitMethod();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		Thread.sleep(500);
		Thread thread2 = new Thread(runnable);
		thread2.start();
		thread2.interrupt();//�����߳�B���ж���
		System.out.println("main end");
		Thread.sleep(5000);
		/*
		 * ��һ�δ������Ϊlock.lock()ʱ���߳�B���ж��ˣ����ǻ���������ִ��
		 * 	�޸Ĵ���Ϊlock.lockInterruptibly()ʱ���߳�B���ж���(���ǵ���interrupt())��
		 * 		���߳�Bִ��lock.lockInterruptibly()��һ�д����ʱ�򣬾ͻ��ж��߳�B�ǲ����Ѿ����ж��ˣ����û�����ȡ����
		 * 			����Ѿ��ж��ˣ�����׳��쳣
		 */
	}
	
	
	//����boolean tryLock()��������:���ڵ���ʱ����δ����һ���̱߳��ֵ�����£��Ż�ȡ������
	@Test
	public void tryLock(){
		final ObjectS objectS = new ObjectS();
		Runnable runnable = new Runnable() {
			public void run() {
				objectS.waitMethod();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		Thread thread2 = new Thread(runnable);
		thread2.start();
		/*
		 * thread2�ڵ���tryLock()������ʱ��thread���Ѿ����������
		 * 	����thread2û�л����
		 */
	}
	
	
	 //����awaitUninterruptibly()��ʹ��,
	@Test
	public void awaitUninterruptibly() throws InterruptedException{
		final ObjectT objectT = new ObjectT();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				objectT.waitMethod();
			}
		};
		thread.start();
		Thread.sleep(1000);
		thread.interrupt();
		/*
		 * ����һ�κ������Ĵ���objectT.waitMethod();��ΪobjectT.waitMethodA();
		 * 	�ٿ��������еĽ����ʲô��ͬ
		 */
	}
	
}

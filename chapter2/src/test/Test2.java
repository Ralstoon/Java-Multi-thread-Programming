package test;

import mythread2.MyThread2;
import mythread2.MyThread3;
import mythread2.MyThread4;
import mythread2.MyThread5;
import mythread2.MyThread7;
import mythread2.MyThread8;
import mythread3.MyThread1;

import org.junit.Test;

import otherObject.MyObject6;
import otherObject.MyObject8;
import otherObject.MyObject9;
import otherObject.PublicVar;
import otherObject2.MyObject1;

public class Test2 {

	//���
	@Test
	public void dataChange(){
		try {
			PublicVar publicVar = new PublicVar();
			MyThread2 myThread2 = new MyThread2(publicVar);
			myThread2.setName("��һ����ֵ�߳�");
			MyThread3 myThread3 = new MyThread3(publicVar);
			myThread3.setName("�ڶ���ȡֵ�߳�");
			myThread2.start();
			myThread3.start();
			Thread.sleep(1000);
			/*
			 * ��������������������Ҫ�ڸ�ֵʱʹ����ͬ��(synchronized),����ȡֵʱ�п��ܳ���һЩ���벻�������⣬
			 * 	��������:�ڶ�ȡʵ������ʱ����ֵ�Ѿ��������̸߳��Ĺ��ˣ��������ڸ�ֵ��ʱ��û����ȫ��ֵ(����Щֵû�и���)
			 * 	����߳̾ͽ��ж�ȡ��
			 * 
			 *  ����ķ���������ȡֵ�ķ����м���synchronize����
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//synchronized������
	@Test
	public void synchronizedEntry(){
		try {
			MyThread4 myThread4 = new MyThread4();
			myThread4.start();
			Thread.sleep(4000);
			/*
			 * 	��������:�Լ������ٴλ�ȡ�Լ����ڲ�����
 			 * 		������һ���̶߳�������ĳ�������������ʱ�����������û���ͷţ������ٴλ�ȡ����������ʱ���ǿ��Ի�ȡ�ģ����û�в����������Ļ����ͻ����������
			 * 			����һ��������һ��ͬ����������Aͬ���������滹��һ��Bͬ��������
			 * 				��ʱ����ִ�������Bͬ������ʱ���Ͳ���Ҫ�ȴ�A����ִ����ϡ�Bͬ����������ֱ��ִ��
			 */
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
	}

	//���������ĸ�����̳�
	@Test
	public void synchronizedFatherAndSon(){
		try {
			MyThread5 myThread5 = new MyThread5();
			myThread5.start();
			Thread.sleep(2000);
			/*
			 * ���ۣ������ڸ�����̳й�ϵ�ǣ���������ȫ����ͨ��"��������"���ø����ͬ������
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//�����쳣�����Զ��ͷ�
	@Test
	public void exceptionNoSynchronized(){
		final MyObject6 myObject6 = new MyObject6();
		Thread a = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject6.method1();
			}
		};
		a.setName("a");
		Thread b = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject6.method1();
			}
		};
		b.setName("b");
		a.start();
		b.start();
		/*
		 * 	����:�߳�a�����쳣���ͷ������߳�b���뷽��������ӡ��ʵ��Ľ��۾��ǳ����쳣�������Զ��ͷ���
		 *
		 */
	}
	
	
	//ͬ�������м̳���
	@Test
	public void synchronizedNoExtends(){
		try {
			final MyObject8 myObject8 = new MyObject8();
			Thread thread = new Thread(){
				@Override
				public void run() {
					super.run();
					myObject8.method();
				}
			};
			thread.setName("a");
			Thread thread2 = new Thread(){
				@Override
				public void run() {
					super.run();
					myObject8.method();
				}
			};
			thread2.setName("b");
			thread.start();
			thread2.start();
			Thread.sleep(10000);
			/*
			 * ����:����������һ��ͬ�������ǣ������ǲ��ܼ̳и����ͬ��������
			 * 		���Ի���������ķ��������synchronized�ؼ���
			 * 
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//ʹ��ͬ�������
	@Test
	public void synchronizedThis(){
		try {
			MyObject9 myObject9 = new MyObject9();
			MyThread7 myThread7 = new MyThread7(myObject9);
			myThread7.setName("a");
			MyThread8 myThread8 = new MyThread8(myObject9);
			myThread8.setName("b");
			myThread7.start();
			myThread8.start();
			Thread.sleep(6000);
			/*
			 * �����������̷߳���ͬһ������object�е�synchronized(this)ͬ��������ǣ�һ��ʱ����ֻ����һ���̱߳�ִ��
			 * 	��һ���̱߳���ȴ���ǰ�߳�ִ���������������ִ�иô����
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
 
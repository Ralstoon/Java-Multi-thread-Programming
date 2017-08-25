package test;

import org.junit.Test;


import other.MyObject;
import other.synchronizedObject.SynchronizedObject;
import other.synchronizedObject.SynchronizedObject2;
import mythread3.MyThread1;
import mythread3.MyThread2;
import mythread3.MyThread3;
import mythread3.MyThread4;
import mythread3.MyThread5;
import mythread3.MyThread6;
import mythread3.MyThread8;
import mythread3.MyThread9;



public class Test3 {

	//��ֹͣ���̣߳�����ֹͣ��ʹ��stop()����
	@Test
	public void stop(){
		try {
			MyThread1 myThread1 = new MyThread1();
			myThread1.start();
			Thread.sleep(800);
			myThread1.stop();
			/*
			 * �̶߳���myThread1ִ��stop�������̶߳���myThread1����run�����ѭ����������
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//ʹ��stop()�������߳��׳��쳣
	@Test
	public void stop2(){
		try {
			MyThread2 myThread2 = new MyThread2();
			myThread2.start();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//ʹ��stop()���������ͷ����Ĳ������
	@Test
	public void stop3(){
		try {
			SynchronizedObject synchronizedObject = new SynchronizedObject();
			MyThread3 myThread3 = new MyThread3(synchronizedObject);
			myThread3.start();
			myThread3.stop();
			System.out.println(synchronizedObject.getUsername()+synchronizedObject.getPassword());
			Thread.sleep(1000);
			/*
			 * ����ʱ��ͻ�������ݵĲ�ͬ������stop����ִ�е�ʱ��
			 * ��ʱ����SynchronizedObject����
			 * 		synchronized public void printString(�Ѿ������ˣ����ⷽ������Thread.sleep(1000)˯��һ����)��
			 * 		��main�߳�ִ�е�stop()������ʱ��myThread3�̻߳��ڼ����ķ������棬ִ��stop(),myThread3�����ͷ������������ݳ���
			 * 			this.username = username;(username��ֵ��)
			 *			Thread.sleep(1000);(��ʱ��ִ��stop�������߳�ֹͣ)
			 *			this.password = password;(passwordû�б���ֵ)
			 *	
			 *	ע������stop()�����Ѿ���JDK�б�������"����/����"�ķ�������Ȼ���ڹ����Ͼ���ȱ�ݣ����Բ������ڳ�������ʹ��stop()����
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//ʹ��return��interrupt��ֹͣ�߳�
	@Test
	public void returnAndInterrupt(){
		try {
			MyThread4 myThread4 = new MyThread4();
			myThread4.start();
			Thread.sleep(10);
			myThread4.interrupt();
			/*
			 * ������interrupt()��return���ʹ�ÿ���ʹ�߳�ֹͣ
			 * ���ǻ��ǽ���ʹ��"���쳣"�ķ�����ʵ���̵߳�ֹͣ
			 * ��Ϊ��catch���л����Խ����쳣�����ף�ʹ�߳�ֹͣ���¼����Դ���
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//��ͣ�߳�(suspend)��ָ��߳�(resume)
	@Test
	public void suspendAndResume(){
		try {
			MyThread5 myThread5 = new MyThread5();
			myThread5.start();
			
			//A�Σ���ͣ�̣߳��̶߳���myThread5�����run����ֹͣ����
			myThread5.suspend();
			System.out.println("ϵͳʱ��" + System.currentTimeMillis() + "�߳���ͣʱi=" + myThread5.getI());
			Thread.sleep(2000);
			System.out.println("ϵͳʱ��" + System.currentTimeMillis() + "�ָ̻߳���i=" + myThread5.getI());
			//�ָ��̣߳��̶߳���myThread5�����run�����ֿ�ʼ����   
			myThread5.resume();
			
			//B��
			Thread.sleep(2000);
			myThread5.suspend();
			System.out.println("ϵͳʱ��" + System.currentTimeMillis() + "�߳���ͣʱi=" + myThread5.getI());
			Thread.sleep(2000);
			System.out.println("ϵͳʱ��" + System.currentTimeMillis() + "�ָ̻߳���i=" + myThread5.getI());
			myThread5.resume();
			
			//C��
			Thread.sleep(2000);
			System.out.println("ϵͳʱ��" + System.currentTimeMillis() + "�߳�û����ͣʱi=" + myThread5.getI());
			Thread.sleep(2000);
			System.out.println("ϵͳʱ��" + System.currentTimeMillis() + "�߳�û�лָ�ʱi=" + myThread5.getI());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//suspend��resume������ȱ��--��ռ  
	@Test
	public void suspendAndResume2(){
		try {
			final SynchronizedObject2 synchronizedObject2 = new SynchronizedObject2();
			Thread thread = new Thread(){
				@Override
				public void run() {
					synchronizedObject2.printString();
				}	
			};
			thread.setName("a");
			thread.start();
			Thread.sleep(1000);
			Thread thread2 = new Thread(){
				@Override
				public void run() {
					System.out.println("�ܽ�ȥ��?");
					synchronizedObject2.printString();
				}
			};
			thread2.start();
			/*
			 * 	��thread����߳̽���SynchronizedObject2.printString()������(�÷����Ѿ�������)��
			 * 		thread�������������ͣ�����߳��õ��˸÷���������һֱ��ͣ������(�������ͷ���)������߳��ǲ������ٴ��õ�������ģ�����ͳ�������
			 * 	����������Ƕ�ռ
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//suspend��resume������ȱ��--��ռ
	@Test
	public void suspendAndResume3(){
		try {
			MyThread6 myThread6 = new MyThread6();
			myThread6.start();
			Thread.sleep(10);
			myThread6.suspend();//�߳�myThread6���ڴ�ӡ�����������ͣ��println���ڱ����߳�ʹ�ã���Ϊprintln�Ǽ�������
			System.out.println("main end...");
			/*
			 * 	myThread6�߳�һֱ�ڴ�ӡi�����ͻȻ�ͱ�suspend()����ͣ�ˣ�����˵myThread6����ʹ��println����(ͣ�ڸ÷�������)��
			 * 	����println�Ǽ������ģ�����myThread6�߳̾�һֱ��ռ�ˣ�����߳̾�û��ȡ�����������û����println����
			 * 	����main�߳̾�û����ӡmain end���
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//suspend��resume������ȱ��--���ݲ�ͬ��
	@Test
	public void dataNotSynchronization() throws InterruptedException{
		final MyObject myObject = new MyObject();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject.setUsernameAndPassword("mo", "123");
			}
		};
		thread.setName("a");
		thread.start();
		Thread.sleep(1000);
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject.print();
			}
		};
		thread2.start();
		Thread.sleep(1000);
		System.out.println("main end");
		/*
		 * 	�������thread������myObject����ע�����ݣ�ԭ��myObjectĬ�ϵ�username��password��a��aa��
		 * 	����ע���������mo��123��������thread�߳�ע����username�ͱ���ͣ�ˣ���û��ע��password�����������ͳ��������ݵĳ���
		 * 
		 */
	}
	

	//yield()����:������ǰ��cpu��Դ
	@Test
	public void yield() throws InterruptedException{
		MyThread8 myThread8 = new MyThread8();
		myThread8.start();
		Thread.sleep(100);
		/*
		 * ʹ��yield()�����Ļ�Ȳ�ʹ�õ����ܶ࣬��Ϊʹ��yield()���Զ�������ǰ��cpu��Դ
		 * 	�����ø�����������ȥռ��cpuִ��ʱ��
		 * ��������ʱ�䲻ȷ�����п��ܸշ��������Ͼͻ��cpuʱ��Ƭ��
		 */
	}

	
	//�̵߳����ȼ�
	@Test
	public void threadPriority(){
		System.out.println("main�̵߳����ȼ���" + Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		/*
		 * Thread.currentThread()�е�currentThread()�����Ǿ�̬�ģ����ǲ���ͨ������Ķ�����в�����
		 * ֻ����Ψһ��ֵ������˵����������currentThread().getPriority()��ֵ�ǹ̶���
		 */
		System.out.println("main�̵߳����ȼ���" + Thread.currentThread().getPriority());
		MyThread9 myThread9 = new MyThread9();
		myThread9.start();
	}
	
}

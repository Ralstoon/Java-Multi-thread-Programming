package test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.print.DocFlavor.STRING;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import mythread1.MythreadA;
import mythread1.MythreadB;
import mythread1.MythreadC;
import object1.ObjectC;
import object1.ObjectE;
import object1.ObjectF;
import object1.ObjectG;
import object1.ObjectH;
import object1.ObjectI;
import object1.ObjectJ;
import object1.ObjectK;
import object1.ObjectL;
import object1.ObjectM;
import object1.ObjectO;

import org.junit.Test;

public class Test2 {

	//������/������ģʽʵ��
	@Test
	public void firstNotify() throws InterruptedException{
		String lock = new String();
		final ObjectC objectC = new ObjectC(lock);
		final ObjectE objectE = new ObjectE(lock);
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				while (true) {
					objectC.setValue();
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				super.run();
				while (true) {
					objectE.getValue();
				}
			}
		}; 
		thread2.start();
		thread.start();
		Thread.sleep(200);
	}
	
	
	  
	/*
	 * �����������������:����ֵ-��������������������߳̽���waiting�ȴ�״̬�����ȫ���̶߳�������waiting״̬�������Ͳ���ִ���κ�ҵ�����ˡ�
	 * 	������Ŀ��ֹͣ״̬��������ʹ����������������ģʽʱ����������    
	 */
	@Test
	public void p_c_allWait() throws InterruptedException{
		String lock = new String();
		final ObjectF objectF = new ObjectF(lock);
		final ObjectG objectG = new ObjectG(lock);
 		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					objectF.setValue();
				}
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					objectG.geValue();
				}
			}
		};
		Thread thread3 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					objectF.setValue();
				}
			}
		};
		thread3.setName("C");
		Thread thread4 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					objectF.setValue();
				}
			}
		};
		thread4.setName("D");
		thread2.setName("B");
		
		thread.start();
		thread2.start();
		thread3.start();
		thread4.start();
		Thread.sleep(500);
		/*
		 * �Ӵ�ӡ����Ϣ�������ʼ���״̬�Ľ��������е��̶߳���waiting״̬
		 * 	Ϊʲô������������?���ж�������ߺ������ߵ�ʱ�򣬵������߻��������ߣ������߻��������ߵĻ����ͻ������������ˡ�
		 * 		����Ҷ��ǳ���waiting״̬
		 * 
		 * 	����İ취����:���������������ߵ�notify()������ΪnotifyAll()�������ɣ�
		 * 		����ԭ����ǲ���֪ͨͬ���̣߳�Ҳ�������ࡣ�����Ͳ�����ּ�����״̬��
		 */
	}
	
	
	
	//һ������һ����:����ջ:ʹ���������ջList�����з������ݣ�ʹ�����ߴ�List��ջ��ȡ�����ݡ�List�����������1��ʵ�黷��ֻ��һ����������һ��������
	@Test
	public void myStack(){
		ObjectH objectH = new ObjectH();
		final ObjectI objectI = new ObjectI(objectH);
		final ObjectJ objectJ = new ObjectJ(objectH);
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					objectJ.pushService();
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				super.run();
				while (true) {
					objectI.popService();
				}
			}
		};
		thread.start();
		thread2.start();
	}
	
	
	
	//ͨ���ܵ������̼߳��ͨ��:�ֽ���:�����ڲ�ͬ�߳�֮�䴫�����ݣ����������������ʱ�ļ�֮��Ķ���
	
	
	
	//����join��ʹ��:�̵�
	@Test
	public void joinTest1(){
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					// TODO Auto-generated method stub
					super.run();
					int vlaue = (int)(Math.random() * 10);
					System.out.println(vlaue);
					Thread.sleep(vlaue);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		//Thread.sleep(?);
		System.out.println("���뵱threadִ��������ִ��");
		System.out.println("��������Ĵ���sleep()�е�ֵӦ��д����?");
		System.out.println("����:��ȷ��");
	}
	
	
	//��join()�����������
	@Test
	public void joinTest2() throws InterruptedException{
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					super.run();
					int waitTime = (int)(Math.random() * 10000);
					Thread.sleep(waitTime);
					System.out.println("thread˯�߽���");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		thread.join();
		System.out.println("���߳�ִִ�����");
		/*
		 * ����join��������ʹ�������߳�Z(������main�߳�)��x�̶߳�������ִ��run()�����е�����
		 * ��ʹ��ǰ�߳�Z���������ڵ��������ã�Ҫ�ȴ��߳�x���ٺ���ִ���߳�z����Ĵ���
		 * 	
		 * 	����join����ʹ�߳��Ŷ����е����ã���һЩ����ͬ�������е�Ч����join��synchronized��������:
		 * 		join���ڲ�ʹ��wait()�������еȴ��ģ���synchronized��ʹ��"���������"ԭ�����ͬ����
		 */
	}
	
	//����join���쳣
	@Test
	public void joinException() throws InterruptedException{
		final Thread threadA = new Thread(){
			@Override
			public void run() {
				super.run();
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					String newString = new String();
					Math.random();
					System.out.println(i);
				}
			}
		};
		
		final Thread threadB = new Thread(){
			@Override
			public void run() {
				try {
					super.run();
					threadA.start();
					threadA.join();
					System.out.println("�߳�B��run������");
				} catch (InterruptedException e) {
					System.out.println("�߳�B��catch��ӡ��");
					e.printStackTrace();
				}
				
			}
		};
		
		
		threadB.start();
		Thread.sleep(100);
		threadB.interrupt();
		Thread.sleep(100);
		/*
		 * ��˵������join��interrupt��������������������쳣��
		 * 	�����̵İ�ť���Ǻ�ɫ��ԭ�����߳�threadA���������У��߳�threadAû�г����쳣
		 */
	}
	
	
	
	//����join(long)��ʹ��
	@Test
	public void joinLong() throws InterruptedException{
		Thread threadA = new Thread(){
			@Override
			public void run() {
				try {
					super.run();
					System.out.println("�߳�A��ʼ��ϵͳʱ����" + System.currentTimeMillis());
					Thread.sleep(4000);
					System.out.println("�߳�A������ϵͳʱ����" + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		threadA.start();
		threadA.join(2000);
		System.out.println("���߳�ִ�����");
		/*
		 * ���̵߳ȴ�������
		 */
	}
	
	
	//join(long)��sleep(long)������
	@Test
	public void joinAndSleep() throws InterruptedException{
		MythreadB B = new MythreadB();
		MythreadA A = new MythreadA(B);
		MythreadC C = new MythreadC(B);
		A.start();
		Thread.sleep(100);
		C.start();
		Thread.sleep(8000);
		/*
		 * �߳�A��run�������������߳�B.A�Ѿ���ȡ��B������
		 * 	��A��run����������Ҫ�ȴ�6s,C��������Ҫִ��B�е�ͬ������������B�Ķ���������A��
		 * 		����Ҫ�ȴ�Aִ����ϣ��ͷ�B�Ķ�������C����ִ��B�е�ͬ������
		 * 
		 *		����ʵ��֤��Thread.sleep(Long);�������ͷŶ�����
		 *
		 *		��MythreadA�е�Thread.sleep(6000); ��Ϊ   mythreadB.join();
		 *			ʱA���ͷ��˶������������߳�C����ִ���߳�B�����е�ͬ������
		 *		˵��join(long)���ͷ����Ĺ���
		 *			
		 */
	}
	
	
	//��ThreadLocal��ʹ��
	@Test
	public void threadLocal(){
		ObjectK objectK = new ObjectK();
		objectK.test();
		/*
		 * ��ThreadLocal������Ǳ����ڲ�ͬ�̼߳�ĸ����ԣ�
		 * 	Ҳ���ǲ�ͬ�߳�ӵ���Լ���ֵ����ͬ�߳��е�ֵ�ǿ��ԷŽ�ThreadLocal���н��б����
		 */
	}
	
	
	//��֤�̱߳����ĸ�����
	@Test
	public void threadLocalA() throws InterruptedException{
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					for (int i = 0; i < 100; i++) {
						ObjectL.t1.set("�߳�A	" + (i+1));
						 System.out.println("�߳�A��ֵ" + ObjectL.t1.get());
						 Thread.sleep(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					for (int i = 0; i < 100; i++) {
						ObjectL.t1.set("�߳�A	" + (i+1));
						 System.out.println("�߳�B��ֵ" + ObjectL.t1.get());
						 Thread.sleep(300);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		thread2.start();
		Thread.sleep(10000);
		/*
		 * û���̶߳���t1������set()����ֵ����ÿ���̻߳�����ȡ���Լ���ֵ
		 */
	}
	
	
	//���������ThreadLocal�࣬ʵ�ֵ�һ�ε���ThreadLocal���get()��������ֵ����null
	@Test
	public void firstValue(){
		final ObjectM t1 = new ObjectM();
		System.out.println(t1.get());
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				System.out.println(t1.get());
			}
		};
		thread.start();
		
	}
	
	
	//InheritableThreadLocal��ʹ��
	 @Test
	 public void InheritableThreadLocal() throws InterruptedException{
		 Thread thread = new Thread(){
			 @Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					super.run();
					for (int i = 0; i < 10; i++) {
						System.out.println("��ThreadA�߳���ȡֵ" + ObjectO.t1.get());
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		 };
		 
		 for (int i = 0; i < 10; i++) {
			 System.out.println("Main�߳���ȡֵ��" + ObjectO.t1.get());
			 Thread.sleep(100);
		 }
		 Thread.sleep(5000);
		 thread.start();
	 }
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package test;

import object1.ObjectU;
import object1.ObjectV;
import object1.ObjectW;

import org.junit.Test;

public class Test3 {
	
	
	/*
	 * 
	 * ʹ��ReentrantReadWriteLock��
	 * 	
	 * 		ReentrantLock������ȫ����������Ч������ͬһʱ��ֻ��һ���߳���ִ��ReentrantLock.lock()�������������
	 * 		������˭�ñ�֤��ʵ���������̰߳�ȫ�ԣ���Ч��ȴ�Ƿǳ��ĵ��¡�
	 * 		
	 * 	������JDK���ṩ��һ�ֶ�д��ReentrantReadWriteLock�࣬���������Լӿ����е�Ч�ʣ���ĳЩ����Ҫ����ʵ�������ķ����У���ȫ����ʹ�ö�д��
	 * 		�������÷����Ĵ��������ٶ�
	 * 
	 * 	��д����ʾҲ����������һ���Ƕ�������ص�����Ҳ��Ϊ����������һ����д������ص�����Ҳ����������Ҳ���Ƕ������֮�䲻���⣬������д�����⣬
	 * 		д����д��֮�以�⡣��û���߳̽���д������ǣ����ж�ȡ�����Ķ���̶߳����Ի�ȡ������������д��������߳�ֻ���ڻ�ȡд������ܽ���д�������
	 * 
	 * 		������߳̿���ͬʱ���ж�ȡ����������ͬһʱ��ֻ����һ���߳̽���д����� 
	 * 
	 */
	
	
	//��ReentrantReadWriteLock��ʹ��:��������
	@Test
	public void readLock(){
		final ObjectU objectU = new ObjectU();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectU.readLock();
			}
		};
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectU.readLock();
			}
		};
		
		thread.start();
		thread2.start();
		/*
		 * �����̼߳���ͬʱ����lock()�����ͺ���Ĵ��룬˵���ڴ�ʹ����lock.readLock()����������߳��������Ч�ʣ�
		 * 		�������߳�ͬʱִ��lock()��������Ĵ���
		 */
	}
	

	//��ReentrantReadWriteLock��ʹ��:дд����
	@Test
	public void writeLock() throws InterruptedException{
		final ObjectV objectV = new ObjectV();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectV.write();
			}
		};
		thread.start();
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectV.write();
			}
		};
		thread2.start();
		Thread.sleep(10000);
		/*
		 * ʹ��д������lock.writeLock()��Ч������ͬһʱ��ֻ����һ���߳�ִ��������ķ���
		 * 
		 */
	}

	
	//��ReentrantReadWriteLock��ʹ��:��д����
	@Test
	public void read_write() throws InterruptedException{
		final ObjectW objectW = new ObjectW();
		
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectW.read();
			}
		};
		thread.start();
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectW.write();
			}
		};
		thread2.start();
		Thread.sleep(3000);
		/*
		 * ��ʵ��˵��"��д"�ǻ���ģ�ֻ���߳̽�����ͬһ������Ķ�������һ���߳��������������д����
		 * 		����Ҫ�ȵ������ͷ�����д�����ܻ�ȡ�ö����д��
		 * 
		 * ͬ��"д��"Ҳ�ǻ���ģ�ֻ��"����"���첽���ǻ����
		 */
	}
	
	
}

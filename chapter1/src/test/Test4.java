package test;

import mythread4.MyThread1;

import org.junit.Test;

public class Test4 {

	/*
	 * �ػ��߳�
	 * 	һ���̲߳����Զ������ģ�ֻ�е�run����ִ�������Ż��Զ�����
	 *		���ǵ�һ���߳����ػ��߳�ʱ��run����û��ִ������������Զ�����(��û�з��ػ��߳�ʱ) 		
	 *	
	 *	�������棬myThread1������Ϊ�ػ��߳�(һ���߳���δstart֮ǰ��Ҫ������Ϊ�ػ��߳���)��
	 *			��main�߳̽���ʱ(���ػ��߳�û����)���ػ��߳�Ҳ�Զ���������setDaemonע�Ϳ���Ч��
	 */
	public static void main(String[] args) {
		try {
			MyThread1 myThread1 = new MyThread1();
			myThread1.setDaemon(true);
			myThread1.start();
			Thread.sleep(700);
			System.out.println("��Ҫ�뿪thread����Ҳ���ٴ�ӡ��Ҳ����ֹͣ��");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//�߳̾������ȼ���
	@Test
	public void priority() throws InterruptedException{
		Thread thread = new Thread(){
			@Override
			public void run() {
				long beginTime = System.currentTimeMillis();
				for(int i=0; i < 500; i++){
					System.out.println("�߳�һ��ӡ" + (i+1));
				}
				long endTime = System.currentTimeMillis();
				System.out.println("�߳�һ��ʱ��" + (endTime - beginTime));
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				long beginTime = System.currentTimeMillis();
				for(int i=0; i < 500; i++){
					System.out.println("�̶߳���ӡ" + (i+1));
				}
				long endTime = System.currentTimeMillis();
				System.out.println("�̶߳���ʱ��" + (endTime - beginTime));
			}
		};
		
		thread.setPriority(10);
		thread2.setPriority(1);
		//��Ϊ�߳�һ�����ȼ����̶߳��ĸߣ�����һ����˵ִ��ͬ���Ĵ����߳�һ�õ�ʱ�����
		thread.start();
		thread2.start();
		Thread.sleep(5000);
	}
	
}

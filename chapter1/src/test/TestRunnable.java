package test;

import myrunnable.MyRunnable;

import org.junit.Test;

public class TestRunnable {
	
	//ͨ��ʵ��Runnable�ӿ�������һ���߳���
	@Test
	public void createThreadByRunnable(){
		//ͨ��ʵ��Runnable�ӿڵ���Ҫ�½�һ��Thread�࣬������ʵ��runnable�ӿڵ���Ķ��� �Ž�Thread��
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
		System.out.println("ending");
	}
	
	
	
}

package test;

import mythread.MyThread1;
import mythread.MyThread2;
import mythread.MyThread3;
import mythread.MyThread4;
import mythread.MyThread5;
import mythread.MyThread6;
import mythread.MyThread8;
import mythread.MyThread9;

import org.junit.Test;

public class Test1 {
	//��ȡ��ǰ�̵߳�����
/*	public static void main(String[] args){
		System.out.println(Thread.currentThread().getName());
	}
*/	
	//�½�һ���߳�
	@Test
	public void createThread(){
		MyThread1 myThread1 = new MyThread1();
		myThread1.start();
		System.out.println("ending");
		//���ʱ���������ending������߳�run������������ݣ���ΪCUP�������ʱ���������߳��е�run����
	}
	
	//��ʾ�̵߳������
	@Test
	public void randomThread(){
		MyThread2 myThread2 = new MyThread2();
		myThread2.setName("mythread");
		myThread2.start();
		try {
			for(int i=0; i<10; i++){
				int time = (int)Math.random()*1000;
				Thread.sleep(time);
				System.out.println("main=" + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�߳�ִ��start()������˳�򲢲����߳�������˳��
	 * 	�̵߳���������cpu�����ģ�CPU����������
	 */
	@Test
	public void randomThreadNomatterWhenStart(){
		MyThread3 t1 = new MyThread3(1);
		MyThread3 t2 = new MyThread3(2);
		MyThread3 t3 = new MyThread3(3);
		MyThread3 t4 = new MyThread3(4);
		MyThread3 t5 = new MyThread3(5);
		MyThread3 t6 = new MyThread3(6);
		MyThread3 t7 = new MyThread3(7);
		MyThread3 t8 = new MyThread3(8);
		MyThread3 t9 = new MyThread3(9);
		MyThread3 t10 = new MyThread3(10);
		MyThread3 t11 = new MyThread3(11);
		MyThread3 t12 = new MyThread3(12);
		MyThread3 t13 = new MyThread3(13);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
		t13.start();
	}
	
	
	
	//�̰߳�ȫ��ʵ����������������������
	@Test
	public void threadSafe(){
		MyThread4 a = new MyThread4("A");
		MyThread4 b = new MyThread4("B");
		MyThread4 c = new MyThread4("C");
		a.start();
		b.start();
		c.start();
		/**
		 * ����һ�������������̶߳���ÿһ���̶߳��и��Ե�count������
		 * �Լ������Լ���count������ֵ��������������Ǳ����������������߳��ǰ�ȫ�ģ������ֶ���̷߳���ͬһ������ͻ������̵߳İ�ȫ����
		 * ���ﲢû�д��ڶ���̷߳���ͬһ�������ͬһʵ������
		 */
	}
		
		//�̰߳�ȫ����:ʵ��������������
		@Test
		public void threadShareData(){
			//��������ͬһ�������ˣ�����߳�ͬʱ����ͬһ���̶߳���
			MyThread5 myThread5 = new MyThread5();
			Thread a = new Thread(myThread5,"A");
			Thread b = new Thread(myThread5,"B");
			Thread c = new Thread(myThread5,"C");
			Thread d = new Thread(myThread5,"D");
			a.start();
			b.start();
			c.start();
			d.start();
			/*	�������ĸ��̴߳�ӡ�Ĳ���Ԥ�ڵĽ��(Ԥ�ڵĽ��Ӧ�����𽥼�һ��)
			 * 		��Ϊ��ĳЩJVM�У�count--����(������ԭ����)�����Ƿ�Ϊ3����1.ȡ��ԭ�е�ֵ2.����count-1 3.��iֵ���и�ֵ
			 *	��Ϊcpu��ִ���ٶȹ��죬�������߳�ִ�е�ʱ�򣬵�һ��ȡ��countֵ���̻߳�û�ж�count���м��������ڶ����߳̾�ȡ����count��ֵ��
			 *	�������߳�ȡ��count��ֵʱ���߳�һ���̶߳� ��û�ж�count���м�һ����
			 *	���Ի�����"���̰߳�ȫ":��Ҫ��ָ����̶߳�ͬһ�����е�ͬһʵ���������в���ʱ�����ֵ������
			 *									ֵ��ͬ�������������Ӱ������ִ������(����Ƿ��������˽�б����Ͳ�������̰߳�ȫ����)��
			 *	
			 */
			
		}
		
		
		//������̰߳�ȫ
		@Test
		public void threahSafe(){
			MyThread6 myThread6 = new MyThread6();
			Thread a = new Thread(myThread6,"A");
			Thread b = new Thread(myThread6,"B");
			Thread c = new Thread(myThread6,"C");
			Thread d = new Thread(myThread6,"D");
			a.start();
			b.start();
			c.start();
			d.start();
		}
		
		//����i--��System.out.println���쳣���������̰߳�ȫ����
		@Test
		public void otherException(){
			MyThread8 myThread8 = new MyThread8();
			Thread a = new Thread(myThread8,"A");
			Thread b = new Thread(myThread8,"B");
			Thread c = new Thread(myThread8,"C");
			Thread d = new Thread(myThread8,"D");
			Thread e = new Thread(myThread8,"E");
			a.start();
			b.start();
			c.start();
			d.start();
			e.start();
			/*
			 * 	��Ȼprintln()�������ڲ���ͬ���ģ�������println()�������ڲ�����synchronized�ؼ���
			 * 	��i--�Ĳ���ȴ���ڽ���println֮ǰ�����ģ����Ի���Ҫ��run()�����м���synchronized
			 * 	���ǲ�����Ϊi--������println������Ǿ���ͬ������
			 * 
			 */
		}
		
		
		//currentThread()����,���ش�������ڱ��Ǹ��̵߳���
		@Test
		public void main(){
			System.out.println(Thread.currentThread().getName());
			/*
			 * ���main�������ڱ�һ���߳���Ϊmain���̵߳���
			 */
		}
		
		
		//����start()��ֱ�ӵ���run����������(1)
		@Test
		public void main1(){
			MyThread9 myThread9 = new MyThread9();
			myThread9.start();
			/*
			 * MyThread9���еĹ��캯���Ǳ�main�������õģ���run()�������������õģ������ɵ���main�������߳̽��е��ã�������cpu���з���ȥ���õ�
			 * 
			 */
		}
		
		
		//����start()��ֱ�ӵ���run����������(2)
		@Test
		public void main2(){
			MyThread9 myThread9 = new MyThread9();
			myThread9.run();	
			/*
			 * ���������ֱ�ӵ���run�����Ļ�������main����ֱ�ӵ��õ�(��û�п���һ���µ��߳�)
			 * ��������cpu������������
			 * ������û���õ����̣߳�����ӿ�ʼ������������һ���߳���ִ�е�
			 * 
			 */
		}
	
	
}

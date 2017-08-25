package test;

import mythread2.MyThread1;
import mythread2.MyThread2;
import mythread2.MyThread3;
import mythread2.MyThread4;
import mythread2.MyThread5;
import mythread2.MyThread6;
import mythread2.MyThread7;
import mythread2.MyThread8;
import mythread2.MyThread9;

import org.junit.Test;

public class Test2 {

	
	/*
	 * �жϵ�ǰ���߳��Ƿ��ڻ��״̬
	 * 		isAlive()���������жϵ�ǰ�߳��Ƿ��Ѿ�����û��
	 */
	@Test
	public void isAlive() throws InterruptedException{
		MyThread1 myThread1 = new MyThread1();
		System.out.println("�̻߳�û������" + myThread1.isAlive());
		myThread1.start();
//		Thread.sleep(1000);
		System.out.println("�߳��Ѿ�������" + myThread1.isAlive());
		/*
		 * ������߳�ִ��ʱ������ǰ���߳�˯��һ�ᣬ��ômyThread1���Ѿ���run�����Ĵ���ִ������ˣ�
		 * 		run����ִ����ϣ��߳�����Ϊfalse(�������ע�ʹ���Ļ�)
		 */
	}
	
	//������̶߳����Թ�������ķ�ʽ���ݸ�Thread���󣬽���strat()ǰ����в���
	@Test
	public void threadAndThis(){
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2);
		System.out.println("thread�߳��Ƿ��Ծ" + thread.isAlive());
		//��ʱ���½����̻߳�û�е���start����
		thread.setName("a");
		thread.start();
		System.out.println("thread�߳��Ƿ��Ծ" + thread.isAlive());
	}
	
	
	//sleep()����(1)
	@Test
	public void sleep(){
		MyThread3 myThread3 = new MyThread3();
		System.out.println("begin" + System.currentTimeMillis());
		myThread3.run();
		System.out.println("end" + System.currentTimeMillis());
		/*
		 * ֱ�ӵ���run�����Ļ������涼��ʹ��main�̵߳ģ�û��ʹ�õ����߳�(����main�߳�ִ��) 
		 * 		��ͬ��ִ�еģ�������һ��һ�е�ִ�У�ֱ�ӵ���run������main�̻߳����run�������棬ִ��������Ĵ���������������ִ�����µĴ���
		 * 			ֻ�еȴ�run������������ݵ�����ϲſ��Լ��������������
		 */
	}
	
	
	//sleep()����(1)
	@Test
	public void sleep2(){
		MyThread4 myThread4 = new MyThread4();
		System.out.println("begin" + System.currentTimeMillis());
		myThread4.start();
		System.out.println("end" + System.currentTimeMillis());
		/*
		 * ��͸�������ȫ��һ���ˣ����첽ִ�еģ�main����ִ��֮��Ĵ��룬�¿������߳�Ҳ��ִ���Լ��Ĵ��룬����ǿ���һ���µ��߳���
		 */
	}
	
	
	//getId()����
	@Test
	public void getId(){
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName() + "  " + currentThread.getId());
	}
	
	
	//ʹ��interrupt()����������ʹ�߳�ֹͣ
	public static void main(String[] args) {
		try {
			MyThread5 myThread5 = new MyThread5();
			myThread5.start();
			Thread.sleep(2000);
			myThread5.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
	}
	
	
	//interrupted()����
	@Test
	public void interrupted(){
		try {
			MyThread6 myThread6 = new MyThread6();
			myThread6.start();
			Thread.sleep(10);
			/*	interrupt()�������������ֹͣ�̵߳ģ���interrupt()��Ч��������for+break�������
			 * 	���Ͼ���ֹͣ������interrupt()����ֻ�ǵ�ǰ�߳��д���һ��ֹͣ�ı�ǣ����������ֹͣ�߳�
			 */
			myThread6.interrupt();
			System.out.println("�Ƿ�ֹͣ1" + myThread6.interrupted());
			System.out.println("�Ƿ�ֹͣ2" + myThread6.interrupted());
			/*
			 * �����̨���濴���̲߳�û��ֹͣ����Ϊ���interrupted()�����ǲ��Ե�ǰ�߳��Ƿ�ֹͣ����ָ��ִ����δ�����̣߳�������main�߳�ִ����δ��룩
			 * 	������δ�����main�̣߳�����߳�ʼ�ն�û��ֹͣ�������Դ�ӡ����false
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//interrupted()����(2)
	@Test
	public void interrupted2(){
		//interrupt()���������ֹͣ�̣߳������������ֹͣ���̣߳������ڵ�ǰ���߳��д���һ��ֹͣ�ı��
		Thread.currentThread().interrupt();//ִ������δ��룬��ǰ�߳̾ʹ���һ��ֹͣ���
		System.out.println("�Ƿ��Ѿ�ֹͣ1" + Thread.interrupted());
		System.out.println("�Ƿ��Ѿ�ֹͣ2" + Thread.interrupted());
		/*	�Ƿ��Ѿ�ֹͣ1true
		 * 	�Ƿ��Ѿ�ֹͣ2false
		 * 
		 * 	���������������Ϊ���ڵ�һ�д����У���ǰ���߳����Ѿ����ֹͣ�˵ģ�  
		 * 	�ڶ���Ϊfalse��ԭ����:interrupted()�����������״̬�Ĺ���(���ǰѱ��ֹͣ��״̬���)
		 * 		���Եڶ��ε���interrupted()�ķ���ֵ��false(����û�б����ֹͣ)
		 */
	}
	
	//isInterrupted()����
	@Test
	public void isInterrupted(){
		try {
			MyThread6 myThread6 = new MyThread6();
			myThread6.start();
			
			/*	����ΪʲôҪ˯һ�ᣬ�ҵ��������Ϊ���߳�(����main�߳�)�����Ѿ�ִ�������
			 * 	��Ȼ�½����̶߳���ûִ����ϣ�����main�߳��Ѿ�ִ�������,�����Ѿ��ر�(��������Ϊ��Ԫ���Ծͽ�����ֹͣ)
			 * 	���������߳�˯һ�ᣬ�г�ֵ�ʱ�����½����̶߳���ȥִ�����ǵ��߳�
			 */
			
			Thread.sleep(20);
			myThread6.interrupt();//�߳��ж�
			System.out.println("�߳��Ƿ��ж�1" + myThread6.isInterrupted());
			System.out.println("�߳��Ƿ��ж�2" + myThread6.isInterrupted());
			/*	�����������Ľ�����
			 * 		1.this.interrupted():���Ե�ǰ�߳��Ƿ��Ѿ����ж�״̬��ִ�к���н�״̬��־�����Ϊfalse�Ĺ���
			 * 		2.this.isInterrupted():�����߳�Thread�����Ƿ��Ѿ����ж�״̬���������״̬��־
			 * 
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//��ֹͣ���߳�:�쳣��
	@Test
	public void exceptionInterrupted(){
		try {
			MyThread7 myThread7 = new MyThread7();
			myThread7.start();
			Thread.sleep(2000);
			myThread7.interrupt();
			/*
			 * interrupt()�÷������ԶԸ��߳̽��б�ǣ�������ж�״̬����������ø��ж�״̬ȥ�����̡߳��÷�������ֱ������߳��ж�
			 * 		���ǿ������������ǣ������жϣ�Ȼ��������ֹͣ�߳�
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//�ڳ�˯��ֹͣ
	@Test
	public void sleepInterrupted(){
		try {
			MyThread8 myThread8 = new MyThread8();
			myThread8.start();
			Thread.sleep(200);
			myThread8.interrupt();//������б��ֹͣ���������Ҫ��ǵ�����̻߳��ڳ�˯�У����б�Ǿͻ��׳��쳣
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main��������");
		/*
		 * �����sleep״̬��ֹͣĳһ�̻߳��׳��쳣�������ֹͣ״ֵ̬�����false
		 */
	}
	
	//�߳�ֹͣ(ִ����interrupt����),��ִ��sleep����
	@Test
	public void beginInterrupteAfterSleep() throws InterruptedException{
		MyThread9 myThread9 = new MyThread9();
		myThread9.start();
		myThread9.interrupt();
		System.out.println("main��������");
		/*
		 * �߳��жϺ���˯�Ļ������׳��쳣
		 */
	}
	
	
}

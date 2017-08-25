package test;

import mythread1.MyThread1;
import mythread1.MyThread2;
import mythread1.MyThread4;
import mythread1.MyThread5;
import mythread1.MyThread6;
import mythread1.MyThread7;
import mythread1.MyThread8;
import mythread1.MyThread9;

import org.junit.Test;

import otherObject.HasPrivateNum;
import otherObject.HasSelfPrivateNum;
import otherObject.MyObject;
import otherObject.MyObject2;


public class Test1 {

	//�����ڲ�����һ���������ǲ�����"���̰߳�ȫ"�����
	@Test
	public void hasSelfPrivateNum() throws InterruptedException{
		HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
		MyThread1 myThread1 = new MyThread1(hasSelfPrivateNum);
		myThread1.start();
		MyThread2 myThread2 = new MyThread2(hasSelfPrivateNum);
		myThread2.start();
		Thread.sleep(20);
	}
	
	
	//ʵ�������ķ��̰߳�ȫ
	@Test
	public void hasSelfPrivateNum2(){
		try {
			HasPrivateNum hasPrivateNum = new HasPrivateNum();
			MyThread4 myThread1 = new MyThread4(hasPrivateNum);
			myThread1.start();
			MyThread5 myThread2 = new MyThread5(hasPrivateNum);
			myThread2.start();
			Thread.sleep(2000);
			/*
			 * 	������myThread1������ע����a��Ȼ������߼����i=50��˯�ˣ�
			 * 		����ʱ��myThread2Ҳ�����ˣ�ע����b�������߼�Ӧ��i=100�����������i=50�ͱ���Ϊi=100��
			 * 		i����Ϊ100�ˣ�myThread1˯�Ѻ��ٴδ�ӡi��ֵ�ͱ���Ϊ100��
			 * 
			 * 	�������:��addUsername()����ǰ����Ϲؼ���synchronized�Ϳ�����
			 * 
			 * 	ʵ�����:�������̷߳���ͬһ�������е�ͬ������ʱһ�����̰߳�ȫ�ġ�
			 */
		} catch (InterruptedException e) {
			//�����жϵ�ʱ���׳��쳣
			e.printStackTrace();
		}
	}
	
	
	//������������
	@Test
	public void manyLock(){
		try {
			//�����½��������󣬾��ǻ�������ˣ�һ�������ж��Ե�һ����
			HasPrivateNum hasPrivateNum1 = new HasPrivateNum();
			HasPrivateNum hasPrivateNum2 = new HasPrivateNum();
			MyThread4 myThread4 = new MyThread4(hasPrivateNum1);
			myThread4.start(); 
			MyThread5 myThread5 = new MyThread5(hasPrivateNum2);
			myThread5.start();
			Thread.sleep(2000);
			/*
			 * ������Ⱥ�˳���ǽ���ģ���myThread4ע����ӡ��һ��i���ͽ�����˯�ߣ�
			 * 	������ʹ�߳�myThread5ע���bҲ�����һ��i����myThread4����ķ��������Ѿ���������?
			 * 	b����ô���룬����synchronized�ؼ��������Ƕ��󣬶�����һ�δ���
			 *		�������ͻ��ж����
			 */
		} catch (InterruptedException e) {//˯�߱��жϵĻ����ͻ��׳��쳣����catch��
			e.printStackTrace();
		}
	}
	
	
	//synchronized������������
	@Test
	public void methodAndLock(){
		try {
			MyObject myObject = new MyObject();
			MyThread6 myThread6 = new MyThread6(myObject);
			myThread6.setName("a");
			myThread6.start();
			MyThread7 myThread7 = new MyThread7(myObject);
			myThread7.setName("b");
			myThread7.start();
			Thread.sleep(2000);
			/*
			 * ���ùؼ���synchronized�����ķ���һ�����Ŷ����е�
			 * 	��ס"����"�����֣�ֻ�й�����Դ�Ķ�д���ʲ���Ҫͬ������������ǹ�����Դ����ô����û��ͬ���ı�Ҫ
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//��һ������һ����ͬ��������һ������ͬ������
	@Test
	public void oneIsSynchronizedOtherIsNO(){
		try {
			MyObject2 myObject2 = new MyObject2();
			MyThread8 myThread8 = new MyThread8(myObject2);
			myThread8.setName("a");
			myThread8.start();
			MyThread9 myThread9 = new MyThread9(myObject2);
			myThread9.setName("b");
			myThread9.start();
			Thread.sleep(2000);
			/*
			 *	����:ͬһ�������У���ͬ�������ͷ�ͬ����������һ���߳��õ�����������ͬ����������ʱ�������߳�Ҳ���Խ���ö���ķ�ͬ������
			 *		����Ƴ����ʱ��ҲҪע�⣬��ʱ��ʵ������ ͬ������ �� ��ͬ������ �����׳������
			 *		
			 *		����˵:����ͬһ��������в���ʱ����һ���߳��ڶ�ͬ���������ж�д(������ָ��ʵ���������ж�д)
			 *				��ʱ��������һ���߳̽��иö���ķ�ͬ������(ͬ���Ƕ�ͬһʵ���������ж�д)������ʱͬ��������û��ִ�н�����
			 *				��ͬ�������ͰѸ�ʵ��������ֵ�޸��ˣ�Ȼ��ͬ�������ٶ�ȡ��ֵ��ʱ��Ͳ���ԭ����Ҫ��ȡ��ֵ��
			 * 
			 * 		�������:
			 * 			��������Ҫ��������Ҫ��ͬһ�����ͬһʵ���������в�����ʱ������������Ҫ����synchronized
			 * 
			 * 		����:
			 * 			1.A�߳��ȳ���object�����Lock����B�߳̿������첽�ķ�ʽ����object�����е�synchronized���͵ķ���
			 * 			2.A�߳��ȳ���object�����Lock��B�߳���������object������������synchronized���͵ķ�������Ҫ�ȴ���Ҳ����ͬ����
			 * 				(ͨ�׵�˵����:һ���߳��õ���һ��������������õ��˸ö�������synchronized���ͷ���������
			 * 				�����̲߳��ܷ����κθö����synchronized�ķ�����
			 * 					Ҳ���Ի�һ��˵��������ͬһ�����������ж���synchronized���͵ķ��������������ֻ��һ������һ��ĳһ�߳��õ���
			 * 					�������̲߳������ٴ��õ���)
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

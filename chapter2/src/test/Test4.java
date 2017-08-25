package test;

import java.util.Iterator;

import org.junit.Test;

import otherObject2.ObejctAC;
import otherObject2.ObjectAA;
import otherObject2.ObjectAC;
import otherObject2.ObjectAD;
import otherObject2.ObjectAE;
import otherObject2.ObjectS;
import otherObject2.ObjectS.PrivateClass;
import otherObject2.ObjectT.classA;
import otherObject2.ObjectU.ClassB;
import otherObject2.ObjectU.ClassC;
import otherObject2.ObjectV;
import otherObject2.ObjectW;
import otherObject2.ObjectX;
import otherObject2.ObjectY;
import otherObject2.ObjectZ;

public class Test4 {

	//��̬��������
	@Test
	public void staticClass(){
		ObjectS objectS = new ObjectS();
		objectS.setUsername("AA");
		objectS.setPassword("BB");
		System.out.println(objectS.getUsername() + " " + objectS.getPassword());
		PrivateClass privateClass = new PrivateClass();
		privateClass.setAge("22");
		privateClass.setAddress("�麣");
		System.out.println(privateClass.getAddress() + privateClass.getAge());
	}
	
	
	//��������ͬ��:ʵ��һ:������������ͬ����������ʹ�õ��ǲ�ͬ����
	@Test
	public void twoMethodUserDifferentLock() throws InterruptedException{
		final classA classA = new classA();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				classA.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				classA.methodB();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(9000);
		/*
		 * ����:�������У���ͬ��ͬ������ʹ�ò�ͬ��������ӡ�Ľ�����첽��
		 * 
		 */
	}
	
	
	//��������ͬ��:ʵ��2
	@Test
	public void testb() throws InterruptedException{
		final ClassB classB = new ClassB();//��һ������������Եĳ�����һ�����ϣ���Ҫ���õ�������Ϊpublic
		final ClassC classC = new ClassC();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				classB.methodA(classC);
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				classB.methodB();
			}
		};
		thread2.setName("B");
		Thread thread3 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				classC.methodB();
			}
		};
		thread3.setName("C");
		thread.start();
		thread2.start();
		thread3.start();
		Thread.sleep(7000);
		/*
		 * ���۾���:
		 * 		B����ClassB�е�methodB����
		 *		C����ClassC�е�methodB������ʱ��Ϳ�ʼ��ӡ���ֵ�
		 *		
		 *			����Aû�е�һʱ�����ClassB�е�methodA����������ΪmethodA����synchronized(ClassC)��������һ��Class����
		 *			��ClassC�е�methodB����Ҳ��ͬ����������ʱ���߳�C�õ���������������߳�Aֻ�еȴ��߳�C�ͷ�������Ĳ����õ���
		 * 
		 */
	}
	
	
	
	//������ĸı�
	@Test
	public void lockObjectChange() throws InterruptedException{
		final ObjectV objectV = new ObjectV();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectV.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectV.methodA();
			}
		};
		thread2.setName("B");
		thread.start();
		Thread.sleep(50);
		thread2.start();
		Thread.sleep(500);
		/*
		 * �ڽ��κ�����������Ϊͬ������ʱ����Ҫע����ǣ��Ƿ��ж���߳�ͬʱ����������
		 * 	���ͬʱ������ͬ������������Щ�߳�֮�����ͬ���ģ�����Ƿֱ��ȡ����������Щ�߳�֮������첽��
		 * 		
		 * 	��Ҫע�����:	
		 * 		ֻҪ���󲻱䣬��ʹ��������Ա��ı䣬���еĽ������ͬ����
		 * 
		 */
	}
	
	
	
	//ֻҪ���󲻱䣬��ʹ�Ƕ�������Ա��ı䣬���еĽ������ͬ����
	@Test
	public void newPropertiesLockOne() throws InterruptedException{
		final ObjectX objectX = new ObjectX();
		final ObjectW objectW = new ObjectW();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectW.methodA(objectX);
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectW.methodA(objectX);
			}
		};
		thread2.setName("B");
		thread2.start();
		Thread.sleep(300);
		thread.start();
		Thread.sleep(3000);
		/*
		 * 	�����B�߳����Ƚ�����ObjectW�е�methodA������ͬ��������а󶨵���ObjectX����
		 * 		������thread2����ȥ֮�󣬽�ObjectX�е�username���Ը��ˣ����Ǿ��Ǹ��ˣ�thread�����޷������ͬ�������
		 * 			
		 * 	����ֻҪ�Ƕ���û�иı䣬��ʹ�Ƕ�������Է������ı䣬���еĽ������ͬ����
		 * 
		 */
	}
	
	
	//volatile�ؼ���(1):�޷�ֹͣ���߳�
	@Test
	public void volatileA(){
		ObjectY objectY = new ObjectY();
		objectY.printStringMethod();
		System.out.println("��Ҫֹͣ��");
		objectY.setContinuePrint(false);
		/*
		 * �߳����޷�ֹͣ�����ģ�
		 * 		ԭ����Ҫ��main�߳�һֱ�ڴ���while()ѭ�������³����ܼ���ִ�к���Ĵ��롣����İ취��ʹ�ö��̼߳���(������Ĵ���)
		 */
	}
	
	
	//volatile�ؼ���(2):���ͬ����ѭ��
	@Test
	public void sotpLoop() throws InterruptedException{
		ObjectZ objectZ = new ObjectZ();
		new Thread(objectZ).start();
		Thread.sleep(1000);
		System.out.println("��Ҫֹͣ��");
		objectZ.setContinue(false);
		/*
		 * ��������Ĵ���ĸ�ʽ������-server������ģʽ��64-bit��jvm��ʱ��
		 * 	�������ѭ����
		 * 		����İ취����ʹ��volatile�ؼ���
		 * 			volatile�ؼ��ֵ����þ���ǿ�ƴӹ�����ջ��ȡ�ñ�����ֵ�������Ǵ��߳�˽������ջ��ȡ�ñ�����ֵ
		 */
	}
	
	
	
	//volatile�ؼ���(3):���ͬ����ѭ��
	@Test
	public void solveInfiniteLoop() throws InterruptedException{
		ObjectAA objectAA = new ObjectAA();
		objectAA.start();
		Thread.sleep(1000);
		objectAA.setRunning(false);
		System.out.println("�Ѿ���ֵΪfalse��");
		Thread.sleep(1000);
		/*
		 * ������win���JDK64�Ļ����� �ǿ���ֹͣ�����ѭ����
		 * 	
		 * 	����ֻҪ����Eclipse��JVM�����в���Ϊ-service
		 * 		����System.out.println("�̱߳�ֹͣ��");�Ͳ��ᱻִ��
		 * 			��Ϊ������objectAA.start();�̵߳�ʱ�򣬱���private boolean isRunning = true;
		 * 			�����ڹ�����ջ���̵߳�˽�ж�ջ�С�
		 * 			��jvm������Ϊ-serviceģʽʱΪ���̵߳�Ч�ʣ��߳�һֱ��˽�еĶ�ջ��ȡ��isRunning��ֵ��true��
		 * 			������objectAA.setRunning(false);����Ȼ��ִ���ˣ����µ�ȴ�ǹ�����ջ�е�isRunning����ֵfalse��
		 * 				����һֱ������ѭ��
		 * 
		 * 	���������ʵ����˽�ж�ջ�е�ֵ�빫����ջ�е�ֵ��ͬ����ɵ�
		 * 		��������������Ҫʹ��volatile�ؼ����ˣ�����ֻҪ���þ��ǵ��̷߳���isRunning�������ʱ��
		 * 			ǿ���Դӹ�����ջ��ȡֵ
		 * 
		 */
	}
	
	
	
	//volatile�ؼ���(4):ʹ��volatile�ؼ���
	@Test
	public void useVolatile() throws InterruptedException{
		ObejctAC obejctAC = new ObejctAC();
		obejctAC.start();
		Thread.sleep(1000);
		obejctAC.setRunning(false);
		Thread.sleep(1000);
		/*
		 * ������ĳ���ȽϾ��Ƕ���һ��volatile�ؼ��֣�����ȴ�����ж�run�����������ѭ��
		 * 
		 * 	ͨ��ʹ��volatile�ؼ��֣�ǿ�ƵĴӹ����ڴ��ж�ȡ������ֵ
		 * 	ʹ��volatile�ؼ���������ʵ�������ڶ���߳�֮��Ŀɼ��ԡ�
		 * 		������������ȱ����ǲ�֧��ԭ����
		 * 
		 * 	volatile��synchronized����һ�±Ƚ�
		 * 		1.�ؼ���volatile���߳�ͬ����������ʵ�֣�����volatile���ܿ϶��Ǳ�synchronizedҪ����
		 * 			������volatileֻ�������ڱ�������synchronized�������η������Լ�����飬����jdk�°汾�ķ�����
		 * 			synchronized�ؼ�����ִ��Ч���ϵõ��ܴ����ߣ��ڿ�����ʹ��synchronized�ؼ��ֵı��ʻ��Ǻܴ�ġ�
		 * 		2.���̷߳���volatile���ᷢ����������synchronized���������
		 * 		3.volatile�ܱ�֤���ݵĿɼ��ԣ������ܱ�֤ԭ���ԣ���synchronized���Ա�֤ԭ���ԣ�Ҳ���Լ�ӱ�֤�ɼ��ԣ�
		 * 			��Ϊ���Ὣ˽���ڴ�͹����ڴ��е�������ͬ����
		 * 		4.�ٴ�����һ�£��ؼ���volatile������Ǳ����ڶ��߳�֮��Ŀɼ��ԣ���synchronized������Ƕ��߳�֮�������Դ��ͬ����
		 * 
		 * 		�̰߳�ȫ����ԭ���ԺͿɼ����������棬java��ͬ�����ƶ���Χ��������������ȷ���̰߳�ȫ�ġ�
		 */
	}
	
	
	//volatile��ԭ���Ե�����
	@Test
	public void volatileThread(){
		//�߳�����
		ObjectAC[] objectAC = new ObjectAC[100];
		
		for (int i = 0; i < 100; i++) {
			objectAC[i] = new ObjectAC();
		}
		
		for (int i = 0; i < 100; i++) {
			objectAC[i].start();
		}
		/*
		 *  ��Ϊ  count++  ��һ�д����Ƿ�������������ɵ�
		 *  	1.���ڴ���ȡ��count��ֵ
		 *  	2.����count��ֵ
		 *  	3.��count��ֵд���ڴ���ȥ
		 *  
		 *  	����֮���Գ������ݵ�������Ծ�����Ϊ������߳�ͬʱִ����count++��һ�д��룬
		 *  		�����е��߳�ִ��+1�Ĳ�������û��д���ڴ��о��������߳̾��Ѿ��ֽ�����count++�����Ծͻ�������
		 *  
		 *  	�ؼ���volatile��Ҫ��ʹ�ó������ڶ��߳��п��Ը�֪ʵ�������������ˣ�
		 *  		���ҿ��Ի�ȡ���µ�ֵʹ�ã�Ҳ�����ö��̶߳�ȡ�������ʱ���Ի�ȡ���µ�ֵʹ��
		 *  	
		 *  	�ؼ���volatile��ʾ�߳�ÿ�δӹ����ڴ��ж�ȡ�����������Ǵ�˽���ڴ��ж�ȡ�������ͱ�֤��ͬ�����ݵĿɼ���
		 *  		����������Ҫע�����:����޸�ʵ�������е����ݣ������i++,Ҳ����i=i+1���������Ĳ�����ʵ������һ��ԭ�Ӳ���4
		 *  			Ҳ���Ƿ��̰߳�ȫ��
		 *  
		 *  
		 *  �������ӽ���İ취������count++�Ǽ���ͬ����
		 */
	}
	
	
	/*
	 * ʹ��ԭ�����i++���в�����������i++������ʹ��synchronized�ؼ���ʵ��ͬ���⣬������ʹ��AtomicIntegerԭ�������ʵ��
	 * 	ԭ�Ӳ����ǲ��ָܷ�����壬û���������߳��ܹ��жϻ�������ԭ�Ӳ����еı���(ԭ���ڼ���Ĺ����У��������߳��ǲ����ܽ����)��
	 * 		һ��ԭ�����;���һ��ԭ�Ӳ������õ����ͣ���������û����������������̰߳�ȫ
	 */
	@Test
	public void atomicInteger(){
		ObjectAD objectAD = new ObjectAD();
		Thread thread = new Thread(objectAD);//new Thread();�������п�����һ��ʵ��Running�ӿڵģ�Ҳ�����Ǽ̳���Thread���
		thread.start();
		Thread[] threadArray =  new Thread[100];
		for (int i = 0; i < 100; i++) {
			threadArray[i] = new Thread(objectAD);
		}
		for (int i = 0; i < 100; i++) {
			threadArray[i].start();
		}
	}
	
	
	
	//synchronized�������volatileͬ������(1):ͣ���µ�ѭ��
	@Test
	public void synchronizedUpdateNewData() throws InterruptedException{
		final ObjectAE objectAE = new ObjectAE();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectAE.runMethod();
			}
		};
		thread.setName("A");
		Thread.sleep(60);
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectAE.stopMethod();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(600);
		System.out.println("�Ѿ�������ֹͣ��ָ��");
		/*
		 * �����ʹ��-service������ģʽ�����������Ŀ�ͻ������ѭ��
		 * 	�õ��������Ǹ����̵߳�����ֵû�п�������ɵ�
		 * 		���ؼ���synchronized���Ծ��п�����
		 * 
		 * 	���Ĵ�����whileѭ���������һ�����Ϳ�����
		 * 	
		 * 		synchronized���Ա�֤ͬһʱ�̣�ֻ��һ���߳̿���ִ��һ��������ĳһ������顣
		 * 			��������������:�����ԺͿɼ��ԡ�ͬ��synchronized�������Խ��һ���߳̿��������ڲ�һ�µ�״̬��
		 * 				�����Ա�֤����ͬ������������ͬ��������ÿ���̣߳���������ͬһ��������֮ǰ���е��޸�Ч��
		 * 
		 * 	ѧϰ���̣߳�Ҫ����"�������⣬���޿ɼ�"���������ն��̣߳�ѧϰ���̲߳�������Ҫ������ 
		 * 	
		 */
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

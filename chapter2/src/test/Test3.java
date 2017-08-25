package test;

import org.junit.Test;
import mythread3.MyThread1;
import mythread3.MyThread2;
import mythread3.MyThread3;
import mythread3.MyThread4;
import otherObject2.MyObject1;
import otherObject2.MyObject2;
import otherObject2.MyObject3;
import otherObject2.MyObject4;
import otherObject2.MyObject5;
import otherObject2.MyObject6;
import otherObject2.MyObject7;
import otherObject2.MyObject8;
import otherObject2.MyObject9;
import otherObject2.ObjectA;
import otherObject2.ObjectB;
import otherObject2.ObjectC;
import otherObject2.ObjectD;
import otherObject2.ObjectE;
import otherObject2.ObjectF;
import otherObject2.ObjectG;
import otherObject2.ObjectH;
import otherObject2.ObjectI;
import otherObject2.ObjectJ;
import otherObject2.ObjectK;
import otherObject2.ObjectL;
import otherObject2.ObjectM;
import otherObject2.ObjectN;
import otherObject2.ObjectO;
import otherObject2.ObjectP;
import otherObject2.ObjectQ;
import otherObject2.ObjectR;
import otherObject2.ObjectR.PrivateClass;
import otherObject2.ObjectS;

public class Test3 {

	//ʹ��ͬ�������ı׶�
	@Test
	public void synchronizedNoGood() throws InterruptedException{
		MyObject1 myObject1 = new MyObject1();
		MyThread1 myThread1 = new MyThread1(myObject1);
		myThread1.setName("a");
		MyThread2 myThread2 = new MyThread2(myObject1);
		myThread2.setName("b");
		myThread1.start();
		myThread2.start();
		Thread.sleep(6000);
	}
	
	
	//ͬ������飬һ��ͬ��һ���첽
	@Test
	public void synchronizedAndNoSynchronized() throws InterruptedException{
		final MyObject2 myObject2 = new MyObject2();
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject2.method();
			}
		};
		thread1.setName("a");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				myObject2.method();
			}
		};
		thread2.setName("b");
		thread1.start();
		thread2.start();
		Thread.sleep(1000);
		/*
		 * 	�����̷߳���ͬһ���󣬿�����һ��ͬ����һ���첽��
		 * 		����ͬ�������Ժ��첽���棬����ͬ�������ܽ��棬��һ���߳̽���ͬ�������Ͳ����������߳��ٽ���ô���� 
		 */
	}
	
	
	//synchronized�������ͬ����
	@Test
	public void synchronizedBlock() throws InterruptedException{
		final MyObject3 myObject3 = new MyObject3();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject3.methodA();
			}
		};
		thread.setName("a");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				super.run();
				myObject3.methodB();
			}
		};
		thread2.setName("b");
		thread.start();
		thread2.start();
		Thread.sleep(7000);
		/*
		 * ����:��һ���̷߳���һ�������ͬ�������ʱ���������̲߳��ܾͷ��ʸö��������ͬ������飬���ʽ�������
		 * 		��˵��synchronizedʹ�õ�"���������"��һ��
		 * 
		 */
	}
	
	
	//��֤ͬ��synchronized(this)�������������ǰ�����
	@Test
	public void synchronizedWholeObject() throws InterruptedException{
		final MyObject4 myObject4 = new MyObject4();
		Thread thread = new Thread(){
			public void run() {
				super.run();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				myObject4.methodA();
			}
		};
		thread.setName("a");
		Thread thread2 = new Thread(){
			public void run() {
				super.run();
				myObject4.methodB();
			}
		};
		thread2.setName("b");
		thread.start();
		thread2.start();
		Thread.sleep(2000);
		/*
		 * 		MyObject4����methodA��methodB�������涼���˴����
		 * 			��synchronized����һ����synchronized(this)�����Ҳ��������ǰ�����
		 * 		����һ���߳�ռ�иô�������������ռ�иö�������д��������ˣ������߳�Ҳ���ܷ��ʸö�������������
		 * 		�����߳�������Ҫ�õ������߳��ͷ�����
		 * 		
		 * 		
		 */
	}
	
	
	//�����������Ϊ���������
	@Test
	public void main() throws InterruptedException{
		final MyObject5 myObject5 = new MyObject5();
		Thread thread = new Thread(){
			public void run() {
				super.run();
				myObject5.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			public void run() {
				super.run();
				myObject5.methodA();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(3000);
		/*
		 * 	java֧������this����:��ʽ��synchronized(��this����)(��this����һ����ʵ������������)
		 * 		����this������ŵ�:�����һ�������ж��synchronizedͬ����������ʱ����Ȼ��ʵ��ͬ����
		 * 		�����ܵ����������Ի�Ӱ�����е�Ч�ʡ��������ʹ��ͬ�����������this����
		 * 		synchronized(��this����)������е�synchronized������synchronized(this)��������첽��
		 * 		����������thisͬ������ȥ��this�������Դ�����Ч��
		 * 
		 * 		anything���Ƕ��������
		 * 
		 */
	}
	
	
	//ͬ��������ͬ�������������໥����
	@Test
	public void synchronizedAndNoSynchronizd() throws InterruptedException{
		final MyObject6 myObject6 = new MyObject6();
		Thread thread = new Thread(){
			public void run() {
				super.run();
				myObject6.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			public void run() {
				super.run();
				myObject6.methodB();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(6000);
		/*
		 * ����:ͬ��������ͬ���������һ����(�����õ��������)��
		 * 		����һ�������������󣬵�һ���߳��õ��˶���������ô������ͬ����������ͬ������� �����̶߳����޷������
		 */
	}
	
	
	//˽�б������̰߳�ȫ
	@Test
	public void privateVariableSafe() throws InterruptedException{
		final MyObject7 myObject7 = new MyObject7();
		Thread thread = new Thread(){
			public void run() {
				super.run();
				myObject7.methodA();
			}
		};
		thread.setName("a");
		Thread thread2 = new Thread(){
			public void run() {
				super.run();
				myObject7.methodA();
			}
		};
		thread2.setName("b");
		thread.start();
		Thread.sleep(1000);
		thread2.start();
		Thread.sleep(2000);
		/*
		 * ����:˽�б������̰߳�ȫ��
		 * 
		 */
	}

	
	//�����������Ϊ��������������������������ͬһ������
	@Test
	public void synchronizedMustOneObject(){
		try {
			final MyObject8 myObject8 = new MyObject8();
			Thread thread = new Thread(){
				public void run() {
					super.run();
					myObject8.methodA();
				}
			};
			thread.setName("a");
			Thread thread2 = new Thread(){
				public void run() {
					super.run();
					myObject8.methodA();
				}
			};
			thread2.setName("b");
			thread.start();
			thread2.start();
			Thread.sleep(4000);
			/*
			 * ����:
			 * 		ʹ��synchronized(��this����)ͬ�������Ļ������������������ͬһ������
			 * 			�������ͬһ���������������ô���еĽ�������첽�ˣ��ͻύ��
			 * 
			 * 	������ӣ�ʹ�õĶ����������һ�������ڵı�������һ��˽�б������������߳�ȥ����ʱ������ͬһ���ˣ�
			 * 		�������еĽ���ͻύ��
			 * 	
			 * 	�����������Ҳ����ף�Ϊʲô��ͬ���̷߳���ͬһ�������˽�б�����ͬ���������̷߳��ʵ�ʱ��һ����������е�һ������������ô���в��õı���ֵ
			 * 
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//��һ�����ӣ�this�������this����ĶԱȣ��õ����ǲ��õ������������������첽��
	@Test
	public void thisAndNoThis(){
		MyObject9 myObject9 = new MyObject9();
		MyThread3 myThread3 = new MyThread3(myObject9);
		myThread3.setName("a");
		MyThread4 myThread4 = new MyThread4(myObject9);
		myThread4.setName("b");
		myThread3.start();
		myThread4.start();
		/*
		 * ���ڶ���ļ�������ͬ(һ����this��һ����anything(��this))���������еĽ�������첽��
		 */
	}
	
	
	
	//����̵߳���ͬһ�������������
	@Test
	public void randomThread(){
		try {
			final ObjectA objectA = new ObjectA();
			Thread thread = new Thread(){
				public void run() {
					super.run();
					for(int i=0; i<100; i++){
						objectA.add("�߳�Aִ��" + (i+1));
					}
				}
			};
			thread.setName("A");
			Thread thread2 = new Thread(){
				public void run() {
					super.run();
					for(int i=0; i<100; i++){
						objectA.add("�߳�Bִ��" + (i+1));
					}
				}
			};
			thread2.setName("B");
			thread.start();
			thread2.start();
			Thread.sleep(6000);
			/*
			 * 	�����н��������ͬ�������еĴ�����ͬ����ӡ�ģ���ǰ�̵߳�"ִ��"��"�˳�"�ǳɶԳ��ֵ�
			 * 	�����߳�A���߳�B��ִ�����첽�ģ�����ֿ��ܳ���"���"�Ļ����������߳�ִ�з�����˳��ȷ����
			 * 	���Ե�A��B�����߳�ִ�д��з�֧�жϵķ���ʱ���ͻ�����߼��ϵĴ����п��ܳ������
			 * 
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//ģ��A��B�����߳�ִ�д��з�֧�жϵķ���ʱ�����������������Ҫ���һ��listֻװһ��Ԫ�ص�
	@Test
	public void misData(){
		try {
			final ObjectC objectC = new ObjectC();
			final ObjectB list = new ObjectB();
			Thread thread = new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					objectC.addServiceMethod(list, "A����");
				}
			};
			thread.setName("A�߳�");
			Thread thread2 = new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					objectC.addServiceMethod(list, "B����");
				}
			};
			thread2.setName("B�߳�");
			thread.start();
			thread2.start();
			Thread.sleep(3000);
			System.out.println("�����listԪ�ظ���" + list.getSize());
			/*
			 * �������Ƽ�����ֻװһ��Ԫ�صģ�����û�з������߼�ʱ������һ���߳��ܽ��룬�������ݳ���
			 * 	
			 * 	�޸Ĵ���:��
			 * 	
			 * 	synchronized (list) {
			 *		if(list.getSize() < 1){
			 *			Thread.sleep(2000);//ģ���Զ�̻���2��ȡ�����ݣ������ԭ������̻߳��������û��ִ��list.add��
			 *							//	����һ���߳��ܽ��У�����list���ݳ���
			 *			list.add(data);
			 *		}
			 *	}
			 *		
			 *		����synchronized (list)�Ϳ��ԶԷ������м�����  
			 *	
			 * 
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//synchronized(��this����x)����ʽ��д���ǽ�x��������Ϊ"���������"��������߳�ͬʱִ��synchronized(x)ͬ��������ǳ�ͬ��Ч��
	@Test
	public void synchronizedThisX() throws InterruptedException{
		final ObjectD objectD = new ObjectD();
		final ObjectE objectE = new ObjectE();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				objectE.methodA(objectD);
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectE.methodA(objectD);
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(6000);
		/*
		 * 	����:���ʹ��ͬһ��"���������"���Ƕ���߳�ִ��c(X){}ͬ�������ʱ��ͬ��Ч��
		 */
	}
	
	
	//ʹ�ò�ͬ��"���������"
	@Test
	public void synchronizedThisXA() throws InterruptedException{
		final ObjectD objectD = new ObjectD();
		final ObjectD objectD2 = new ObjectD();
		final ObjectE objectE = new ObjectE();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				objectE.methodA(objectD);
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectE.methodA(objectD2);
			}
		};
		thread2.setName("B");
		thread2.start();
		thread.start();
		Thread.sleep(6000);
		/*
		 * ����:����߳�ִ�в�ͬ��"���������"���ǲ�ͬ����
		 */
	}
	
	
	
	//��ͬ��������� synchronized(��this��X)����X��Ҳ��ͬ����������ͬ��������е�synchronized(��this��X){����}Ҫ��X�е�ͬ������ͬ��
	@Test
	public void aa() throws InterruptedException{
		final ObjectF objectF = new ObjectF();
		final ObjectG objectG = new ObjectG();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectG.methodA(objectF);
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectG.methodA(objectF);
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(6000);
	}
	
	
	
	//�����߳�ִ��X���󷽷������synchronized(this)�����
	@Test
	public void synchronizedOtherThread() throws InterruptedException{
		final ObjectH objectH = new ObjectH();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectH.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectH.methodA();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(1000);
		/*
		 * ����:���������߳�ִ��x���������ͬ������Ҳ�ǳ���ͬ����Ч����
		 * 
		 */
	}
	
	
	//��̬ͬ��synchronized��������static�����ϼ���synchronized�����
	@Test
	public void staticSynchronized() throws InterruptedException{
		final ObjectI objectI = new ObjectI();
		final ObjectI objectI2 = new ObjectI();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectI.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectI2.methodA();
			}
		};
		thread2.setName("B");
		thread2.start();
		thread.start();
		Thread.sleep(2000);
		/*
		 * ����:
		 * 		synchronized�ؼ��ּӵ�static��̬�������Ǹ�Class�������ģ�
		 * 		��synchronized�ؼ��ּӵ���static�ϷǾ�̬���Ǹ�����������
		 * 		
		 * 		synchronized+static ��һ�������������еĶ��������õ�
		 */
	}
	
	
	//��֤:synchronized+static �� synchronized+��static ����ͬһ����
	@Test
	public void staitcOrNoStatic() throws InterruptedException{
		final ObjectJ objectJ = new ObjectJ();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectJ.methodStatic();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectJ.methodNoStatic();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(2000);
		/*
		 * 		�����̶߳�ͬһ���������������(һ����static��ͬ��������һ���Ƿ�static��ͬ������)��������첽ִ��
		 * 
		 * ����:synchronized+static �� synchronized+��static ����ͬһ����
		 * 
		 * 		synchronized+static
		 * 			 ��һ��Class���������еĶ���ʵ��������Ч��
		 * 
		 * 		synchronized+��static	
		 * 			��һ�Ѷ�������ֻ��һ����������Ч�ģ������ֻ����סһ������
		 * 
		 */
	}
	
	
	//ʹ��Class��: �����̶߳���������ʵ���������ͬ��ִ�е�
	@Test
	public void TwoThreadSynchronizedStaitc() throws InterruptedException{
		final ObjectK objectK = new ObjectK();
		final ObjectK objectK2 = new ObjectK();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectK.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectK2.methodA();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(2000);
		/*
		 *	����: �������̶߳�����������ʵ���������в�����
		 *		ʹ�õ���Class��������ִ�еĽ������ͬ����
		 * 
		 * 		����Class�� ��������Class�ֽ��룬�Ƕ������еĶ��󣬶��������ĳһ��ʵ��������Եģ�
		 * 			�������еĶ����õ�synchronized+static����ͬ��ִ�е�
		 */
	}
	

	
	//ͬ��synchronized(class)�����
	@Test
	public void synchronizedClass() throws InterruptedException{
		final ObjectL objectL = new ObjectL();
		final ObjectL objectL2 = new ObjectL();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectL.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectL2.methodB();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(2000);
		/*
		 *	����:��synchronized(class)Ҳ��һ���ģ���Ϊclass�ֽ����ǶŶ�һ�޶��ģ�
		 *		����synchronized(class)�������е��߳����еĶ�����һ���ģ��������ж��ٸ��̻߳����Ƕ��󣬶����첽ִ�е�
		 */
	}
	
	
	//��������String�ĳ���������(1)
	@Test
	public void aboutString(){
		String a = "aa";
		String b = "aa";
		System.out.println(a == b);
		/*
		 * 		��jvm����String�����ػ���Ĺ��ܣ����Դ�ӡ�Ľ����true
		 */
	}
	
	
	//��������String�ĳ���������(2):synchronizedͬ�����ʹ��
	@Test
	public void synchronizedString() throws InterruptedException{
		final ObjectM objectM = new ObjectM();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectM.methodA("AA");
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectM.methodA("AA");
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(10000);
		/*
		 * 	�����������������ΪString������ֵ����AA�������߳̾�����ͬ�ģ��������B�̲߳���ִ�У�
		 * 		�����String�����ش��������⣬�����ڴ�����������ͬ��synchronized()����鶼��ʹ��String��Ϊ���Ķ���
		 * 			����ʹ�������ģ�����new Object()ʵ����һ��Object���󣬵�������û�зŽ�������
		 * 
		 */
	}
	
	
	//ʹ��new Object()����Ϊͬ�������Ķ���
	@Test
	public void otherObjectAsSynchronized() throws InterruptedException{
		final ObjectN objectN = new ObjectN();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectN.methodA(new Object());
			}
		}; 
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectN.methodA(new Object());
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(5000);
	}
	
	
	//ͬ��synchronized�������޵ȴ�����
	@Test
	public void synchronizedAlway() throws InterruptedException{
		final ObjectO objectO = new ObjectO();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectO.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectO.methodA();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(6000);
		/*
		 * �߳�A������������ǽ�����ѭ�����߳�B����Զ�ò������еĻ��ᣬ
		 * 		�����ˣ�����ʹ��ͬ����������������������
		 * 
		 */
	}

	
	
	//������������,ʹ�ò�ͬ�������������ͬ���������޵ȴ�����,ʹ��ͬ�������������̵߳���������
	@Test
	public void userOtherObject() throws InterruptedException{
		final ObjectP objectP = new ObjectP();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectP.methodA();
			}
		};
		thread.setName("A");
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				objectP.methodB();
			}
		};
		thread2.setName("B");
		thread.start();
		thread2.start();
		Thread.sleep(5000);
		/*
		 * ����ʹ�ò�ͬ�Ķ�������ͬһ������Ĳ�ͬ��ͬ����������ͬ���Ͳ��������ѭ�������������̲߳��ܽ����������
		 * 
		 */
	}
	
	
	//���̵߳���������,���ǲ�ͬ���̶߳��ڵȴ�һ�����������ܱ��ͷŵ���,�������̵߳�"����"����
	@Test
	public void deadLock() throws InterruptedException{
		ObjectQ objectQ = new ObjectQ();
		objectQ.setFlag("a");
		Thread thread = new Thread(objectQ);
		thread.start();
		Thread.sleep(100);
		objectQ.setFlag("b");
		Thread thread2 = new Thread(objectQ);
		thread2.start();
		/*
		 * 	java�߳�������һ������Ķ��߳����⣬��Ϊ��ͬ���̶߳��ڵȴ����������ܱ��ͷŵ������Ӷ��������е������޷��������
		 * 		�����ǳ�����Ƶ�bug������Ƴ���ʱ��Ҫ����˫��������жԷ������������
		 * 
		 * 		��ʵ��ʹ��synchronizedǶ�׵Ĵ�����ʵ����������ʵ��ʹ��synchronizedǶ��Ҳ���������������
		 * 			��Ƕ��û�й�ϵ����Ҫ������Ľṹ���ˣ�ֻҪ�ǻ���ȵ��Է��ͷŵ������п��ܳ�������
		 * 
		 */
	}
	
	
	//�������뾲̬������
	
	//�������������
	@Test
	public void simpleInnerClass(){
		ObjectR objectR = new ObjectR();
		objectR.setUsername("aa");
		objectR.setPassword("bb");
		System.out.println(objectR.getUsername() + " " + objectR.getPassword());
		PrivateClass privateClass = objectR.new PrivateClass();//����ڲ�������ԵĴ��벻��ͬһ�����£���ô��Ҫ�����ڲ��������������Ϊpublic
		privateClass.setAge("22");
		privateClass.setAddress("�麣");
		System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
		/*
		 * ��Ҫʵ�������������Ҫʹ�����µĴ���:
		 * 				PrivateClass privateClass = objectR.new PrivateClass();
		 */
	}
}
      
package test;

import object1.ObjectA;
import object1.ObjectB;

import org.junit.Test;

public class Test1 {

	//wait/notify������:��ʹ�õȴ�/֪ͨ����ʵ���̼߳��ͨ�ţ�������Ҳ�����volatile�ؼ���
	@Test
	public void twoThreadTransData() throws InterruptedException{
		final ObjectA list = new ObjectA();
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						list.add();
						System.out.println("�����" + ( i + 1 ) + "��Ԫ��");
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				try {
					while (true) {
						if (list.size() == 5) {
							System.out.println("���ϵ�Ԫ��Ϊ5���߳�Ҫ�˳�");
							throw new InterruptedException();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		thread2.start();
		Thread.sleep(9000);
		/*
		 * 
		 * ��Ȼ�����߳�ʵ����ͨ�ţ�������һ���׶˾��ǣ��߳�thread2�����ѯ���������ĳһ����������������˷�cpu����Դ
		 * 	�����ѯ��ʱ������С���п���ȡ������Ҫ�����ݡ�
		 * 		���Ծ���Ҫ��һ�ֻ���ʵ�ּ���cpu����Դ�˷�
		 * 			���һ�����ʵ���̼߳��ͨ��
		 * 
		 */
	}
	
	
	
	//�ȴ�/֪ͨ���Ƶ�ʵ��:waitʹ�߳�ֹͣ���У���Notify����ʹֹͣ���̼߳�������
	@Test
	public void waitAndNotify(){
		try {
			String string = new String("");
			string.wait();
			/*
			 *	���ֶ����ԭ����û��"���������"��Ҳ���Ǹ÷���û��ͬ������ 
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//ʹ��wait
	@Test
	public void useWait(){
		try {
			String lock = new String();
			System.out.println("syn����");
			synchronized (lock) {
				System.out.println("syn��һ��");
				lock.wait();
				System.out.println("wait����Ĵ���");
				/*
				 * �߳���ִ��lock.wait();��ֹͣ��û��ִ������Ĵ����ˣ������̲߳�û��ֹͣ
				 */
			}
			System.out.println("syn����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	//ʹ��notify
	@Test
	public void notifyTest() throws InterruptedException{
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				System.out.println("�߳�A��syn����Ĵ���");
				synchronized (lock) {
					try {
						System.out.println("wait��һ�д���");
						lock.wait();
						System.out.println("wait��һ�д���");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				System.out.println("�߳�B��syn����Ĵ���");
				synchronized (lock) {
						System.out.println("notify��һ�д���");
						lock.notify();
						System.out.println("notify��һ�д���");
				}
			}
		};
		thread.start();
		Thread.sleep(500);
		thread2.start();
		/*
		 * 	thread���ȱ�ִ�У�����ȴ�״̬���ͷŶ�����
		 * 		thread2����������lock�������������ڳ�˯��thread����û�������ͷ���������thread2���н�����
		 * 			�ͷŶ�������thread��ȡ�������������������µĴ���
		 */
	}
	
	
	//ʹ��wait��notifyʵ��ǰ���  ����Ԫ�ص���5��ʱ��һ���߳��˳�
	@Test
	public void test() throws InterruptedException{
		final ObjectB list = new ObjectB();
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				synchronized (lock) {
					try {
						if (list.getSize() != 5) {
							System.out.println("wait��һ�д���");
							lock.wait();
							System.out.println("wait��һ�д���");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				synchronized (lock) {
					try {
						for (int i = 0; i < 10; i++) {
							list.add();
							if(list.getSize() == 5){
								lock.notify();
								System.out.println("�ѷ���֪ͨ");
							}
							System.out.println("�������" + (i+1) + "��Ԫ��");
							Thread.sleep(50);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
		Thread.sleep(500);
		thread2.start();
		Thread.sleep(3000);
		/*
		 * 	lock.wait()����һ����������������˵���ˣ�ִ����notify()�����Ķ��󣬲�����ֱ���ͷ��������ǵȴ���ͬ������ִ����
		 * 		�Ż��ͷ������Ż����ִ��wait���µĴ���
		 * 
		 * 	notify()��������������ѵȴ������еȴ�ͬһ������Դ��"һ��"�̣߳���ʹ�߳��˳��ȴ����У����������״̬��
		 * 		Ҳ����notify()������֪ͨ"һ��"�߳�
		 * 
		 */
	}
	
	
	
	//����wait()���ͷ���notify()�����ͷ�
	@Test
	public void waitReleaseLock(){
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("�߳�һwait����Ĵ���");
						lock.wait();
						System.out.println("�߳�һwait����Ĵ���");
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
					synchronized (lock) {
						System.out.println("�̶߳�wait����Ĵ���");
						lock.wait();
						System.out.println("�̶߳�wait����Ĵ���");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		thread2.start();
		/*
		 * 	��������д��룬����wait����Ĵ��룬Ҳ����˵���߳�һִ����wait֮ǰ�Ĵ����ִ��wait�ͽ�����wait״̬���ͷ��˶�����
		 * 		֮���̶߳���ȡ�˶�������ͬ��Ҳ��ִ��wait����Ĵ���
		 */
	}
	
	
	
	//����wait()���ͷ���notify()�����ͷ�
	@Test
	public void notifyHoldLock() throws InterruptedException{
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("wait����Ĵ���");
						lock.wait();
						System.out.println("wait����Ĵ���");
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
				synchronized (lock) {
					System.out.println("notify����Ĵ���");
					lock.notify();
					System.out.println("notif����Ĵ���");
				}
			}
		};
		thread.start();
		thread2.start();
		/*
		 * thread�߳�ִ����wait()��lock�Ķ������ͷţ�thread2�̻߳����lock�Ķ�������ִ����notify()(thread������)��
		 * 		��thread2���������ͷŶ��������ȴ��߳�thread2ִ���������ͷŶ�������thread���»�ö�����
		 * 
		 * 	ʵ��˵��:����ִ����notify()�������ڵ�ͬ��synchronized��������ͷ���
		 */
	}
	
	
	//��interrupt��������wait����
	@Test
	public void waitInterruptException() throws InterruptedException{
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					synchronized (lock) {
						System.out.println("waitǰ��Ĵ���");
						lock.wait();
						System.out.println("wait����Ĵ���");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("�����쳣�ˣ���Ϊ��wait״̬���̱߳��ж���");
				}
			}
		};
		thread.start();
		Thread.sleep(50);
		thread.interrupt();
		/*
		 * ���̳߳�wait()״̬ʱ�������̶߳����interrupt()���������java.lang.InterruptedException�쳣
		 */
	}
	
	
	//ֻ֪ͨһ���߳�
	@Test
	public void notifyOneThread() throws InterruptedException{
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("�߳�1ǰ");
						lock.wait();
						System.out.println("�߳�1��");
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
					synchronized (lock) {
						System.out.println("�߳�2ǰ");
						lock.wait();
						System.out.println("�߳�2��");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread3 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("�߳�3ǰ");
						lock.wait();
						System.out.println("�߳�3��");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread4 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				synchronized (lock) {
					System.out.println("notifyǰ");
					lock.notify();
//					lock.notify();
//					lock.notify();
//					lock.notifyAll();//��������wait�е��߳�
					System.out.println("notify��");
				}
			}
		};
		thread.start();
		thread2.start();
		thread3.start();
		Thread.sleep(500);
		thread4.start();
		/*
		 * ����notify()���������һ���߳�
		 * 	������notify()����n��ʱ���ỽ��n��wait�е��̸߳���
		 */
	}
	
	
	
	//����wait(long)��ʹ��:�ȴ�ĳһʱ�����Ƿ����̶߳��份�ѣ�����������ʱ������Զ�����
	@Test
	public void waitHasParam() throws InterruptedException{
		final Object lock = new Object();
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					synchronized (lock) {
						System.out.println("waitǰ");
						lock.wait(2000);
						System.out.println("wait��");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
//		Thread.sleep(2500);
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				synchronized (lock) {
					System.out.println("notifyǰ");
					lock.notify();
					System.out.println("notify��");
				}
			}
		};
		thread2.start();
		Thread.sleep(1000);
	}
}

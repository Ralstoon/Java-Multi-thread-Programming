package mythread;

//��������̰߳�ȫ���⡱
public class MyThread6 extends Thread{
	private int count = 5;

	/*	
	 *	����ʹ��synchronized�ؼ��֣��Ƕ���߳�ִ��run����ʱ���Ŷӵķ�ʽ���д���
	 *	һ���߳���Ҫ����run����������Ҫ�õ������
	 *	��һ���̵߳���runǰ�������ж�run������û�б��������еĻ�֤�������߳��Ѿ��õ��������
	 *	֤���������߳����ڵ��ø÷�����Ҫ�ȴ��õ���������̵߳��ý�������ִ��run�������ͷ���������ܵ���һ���߳�ִ��
	 *	
	 *	synchronized�������������ͷ����Ͻ��м���
	 *
	 */
	synchronized public void run() {
		super.run();
		count--;
		System.out.println("��:" + Thread.currentThread().getName() + "�����count=" + count);
	}
	
}

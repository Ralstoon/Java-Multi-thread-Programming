package mythread;

//����i--��System.out.println���쳣
public class MyThread8 extends Thread {
	private int i = 5;
	@Override
	//��println()�������ڲ���ͬ���ģ�����i--�Ĳ���ȴ����println()����ִ��֮ǰ���в����ģ����Ի���Ҫ��run��������ͬ�������
	synchronized public void run() {
		System.out.println("i=" + (i--) + "��ǰ�̵߳�����" + Thread.currentThread().getName());
	}
}

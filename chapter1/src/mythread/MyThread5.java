package mythread;

//�̰߳�ȫ����:�������ݣ������߳̿��Է���ͬһ����
public class MyThread5 extends Thread {
	private int count = 12;
	
	@Override
	public void run() {
		super.run();
		count--;
		System.out.println("��" + Thread.currentThread().getName() + "����ý��Ϊ" + count);
		//ÿһ���̶߳�����ִ��run����һ�ξ��ǿ��Զ�count����һ�μ�������
	}
	
}

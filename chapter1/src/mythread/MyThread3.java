package mythread;

//��ʾִ��start()������˳�򲻴����߳�������˳��
public class MyThread3 extends Thread {
	private int i;
	
	//����һ�������������øù���������һ���µĶ��󣬸ö���ӵ��һ������i ����ֵ
	public MyThread3(int i ) {
		super();
		this.i = i;
	}
	
	//����һ���̶߳����ʱ��ÿ��  ����.start()����������run����������start�����������첽ִ�еģ�cpu�����ѡȡһ��ʱ�����ȥ���ø��߳�
	@Override
	public void run() {
		System.out.println(i);
	}
	
}

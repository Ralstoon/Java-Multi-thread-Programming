package otherObject2;

//ͬ���������ͬ����
public class MyObject3 {

	//ͬ�������
	public void methodA(){
		try {
			synchronized (this) {
				System.out.println("ͬ������鿪ʼ" + "���߳�" + Thread.currentThread().getName() + "ִ��");
				Thread.sleep(3000);
				System.out.println("ͬ����������" + "���߳�" + Thread.currentThread().getName() + "ִ��");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ͬ������飬û��˯��
	public void methodB(){
		synchronized (this) {
			System.out.println("ͬ������鿪ʼ" + "���߳�" + Thread.currentThread().getName() + "ִ��");
			System.out.println("ͬ����������" + "���߳�" + Thread.currentThread().getName() + "ִ��");
		}
	}
	
}

package otherObject;

//ͬ�������м̳���
public class MyObject8 extends MyObject7{
	
	//ȥ��synchronized����Ч��
	synchronized public void method(){
		try {
			System.out.println("���߳�" + Thread.currentThread().getName() + "��ʼ");
			Thread.sleep(2000);
			System.out.println("���߳�" + Thread.currentThread().getName() + "����");
			super.method();//���ø����method����
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

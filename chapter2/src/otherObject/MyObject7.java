package otherObject;

//ͬ�������м̳���
public class MyObject7 {
	
	synchronized public void method(){
		try {
			System.out.println("���߳�" + Thread.currentThread().getName() + "��ʼ");
			Thread.sleep(2000);
			System.out.println("���߳�" + Thread.currentThread().getName() + "����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

package otherObject;

//synchronized������������
public class MyObject {
	
	synchronized public void method1(){
		try {
			System.out.println("method ��ʼ");
			System.out.println("��ǰ�߳���" + Thread.currentThread().getName() + "��ǰʱ����" + System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println("����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

package otherObject2;

//ͬ��������ͬ���������໥������
public class MyObject6 {

	public void methodA(){
		synchronized (this) {
			try {
				System.out.println("�߳�" + Thread.currentThread().getName() + "������ͬ���������" );
				Thread.sleep(1000);
				System.out.println("�߳�" + Thread.currentThread().getName() + "�뿪��ͬ���������" );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	synchronized public void methodB(){
			System.out.println("�߳�" + Thread.currentThread().getName() + "����ͬ��������");
			System.out.println("�߳�" + Thread.currentThread().getName() + "������ͬ��������" );
	}
	
}

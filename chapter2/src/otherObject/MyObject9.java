package otherObject;

//ͬ�������:��ͬ���߳�ͬʱ��ͬһ�����ͬ���������з���
public class MyObject9 {
	
	public void method(){
		synchronized(this){
			try {
				System.out.println("�߳�" + Thread.currentThread().getName() + "��ʼִ��ͬ�������");
				Thread.sleep(2000);
				System.out.println("�߳�" + Thread.currentThread().getName() + "����ִ��ͬ�������");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

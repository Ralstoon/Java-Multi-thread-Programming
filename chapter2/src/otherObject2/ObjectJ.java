package otherObject2;

//��֤:synchronized+static��synchronized+��static����ͬһ����
public class ObjectJ {

	
	synchronized public static void methodStatic(){
		try {
			System.out.println(Thread.currentThread().getName() + "�߳̽���ͬ����̬����"); 
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + "�߳��˳�ͬ����̬����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void methodNoStatic(){
		try {
			System.out.println(Thread.currentThread().getName() + "�߳̽���ͬ���Ǿ�̬����"); 
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + "�߳��˳�ͬ���Ǿ�̬����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

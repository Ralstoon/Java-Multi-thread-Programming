package otherObject2;
//ʹ��Class��: �����̶߳���������ʵ���������ͬ��ִ�е�
public class ObjectK {
	
	synchronized public static void methodA(){
		try {
			System.out.println(Thread.currentThread().getName() + "�߳̽���");
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + "�߳��˳�");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

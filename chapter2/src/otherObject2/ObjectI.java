package otherObject2;

//��̬ͬ������synchronized����
public class ObjectI {
	
	synchronized public static void methodA(){
		try {
			System.out.println(Thread.currentThread().getName() + "�߳̽���");
			Thread.sleep(200);
			System.out.println(Thread.currentThread().getName() + "�߳��˳�");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}

package otherObject2;

//synchronized(Class)�����
public class ObjectL {

	public void methodA(){
		synchronized (ObjectL.class) {
			try {
				System.out.println(Thread.currentThread().getName() + "�߳̽���methodA����");
				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName() + "�߳��˳�methodA����");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void methodB(){
		synchronized (ObjectL.class) {
			System.out.println(Thread.currentThread().getName() + "�߳̽���methodB����");
			System.out.println(Thread.currentThread().getName() + "�߳��˳�methodB����");
		}
	}
	
}

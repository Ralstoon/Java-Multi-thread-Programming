package otherObject2;

//������ĸı�
public class ObjectV {

	private String lock = "123";
	
	public void methodA(){
		synchronized (lock) {
			try {
				System.out.println(Thread.currentThread().getName() + "�߳̽���" );
				lock = "456";
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName() + "�߳��˳�" );
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
	
}

package otherObject2;

public class ObjectF {

	synchronized public void mehtodA(){
		try {
			System.out.println("ͬ������" + Thread.currentThread().getName() + "�߳̽���");
			Thread.sleep(1000);
			System.out.println("ͬ������" + Thread.currentThread().getName() + "�߳��˳�");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

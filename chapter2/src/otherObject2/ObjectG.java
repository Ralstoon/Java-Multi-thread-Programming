package otherObject2;

public class ObjectG {

	public void methodA(ObjectF objectF){
		synchronized (objectF) {
			try {
				System.out.println("ͬ�������" + Thread.currentThread().getName() + "�߳̽���");
				Thread.sleep(1000);
				System.out.println("ͬ�������" + Thread.currentThread().getName() + "�߳��˳�");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

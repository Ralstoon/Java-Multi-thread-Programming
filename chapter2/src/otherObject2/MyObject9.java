package otherObject2;

//this�������this����
public class MyObject9 {

	private String anything = new String();
	
	//A������ͬ������
	synchronized public void methodA(){
		System.out.println(Thread.currentThread().getName() + "�߳̽���");
		System.out.println(Thread.currentThread().getName() + "�߳��˳�");
	}
	
	
	//����B�Ƿ�this�����ͬ�������
	public void methodB(){
		synchronized (anything) {
			System.out.println(Thread.currentThread().getName() + "�߳̽���");
			System.out.println(Thread.currentThread().getName() + "�߳��˳�");
		}
	}
	
}

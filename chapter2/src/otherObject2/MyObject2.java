package otherObject2;

//ͬ������飬һ��ͬ��һ���첽
public class MyObject2 {

	public void method(){
		for(int i=0; i<10; i++){
			System.out.println("�߳�" + Thread.currentThread().getName() + "�첽���" + i);
		}
		synchronized (this) {
			for(int i=0; i<10; i++){
				System.out.println("�߳�" + Thread.currentThread().getName() + "ͬ�����" + i);
			}
		}
	}
	
}

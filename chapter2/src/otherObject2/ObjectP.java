package otherObject2;

//ʹ�ò�ͬ�������������ͬ���������޵ȴ�����
public class ObjectP {
	
	Object object1 = new Object();
	
	public void methodA(){
		synchronized (object1) {
			System.out.println(Thread.currentThread().getName() + "�߳̽�����methodA����");
			boolean falg = true;
			while(falg){
				//����������ѭ��
			}
			System.out.println(Thread.currentThread().getName() + "�߳��˳���methodA����");
		}
	}
	
	Object object2 = new Object();
	
	public void methodB(){
		synchronized (object2) {
			System.out.println(Thread.currentThread().getName() + "�߳̽����˷���B");
			System.out.println(Thread.currentThread().getName() + "�߳��˳��˷���B");
		}
	}
}

package otherObject2;

//synchronizedc(this) �������������ǰ�����
public class MyObject4 {

	public void methodA(){
		synchronized (this) {
			System.out.println("�첽����ִ��" + Thread.currentThread().getName());
		}
		
	}
	
	public void methodB(){
		synchronized (this) {
			System.out.println("ͬ������" + Thread.currentThread().getName());
			for(int i=0; i<1000; i++){
				System.out.println(i);
			}
		}
	}
	
}

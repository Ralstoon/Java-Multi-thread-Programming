package otherObject;

//��һ������һ����ͬ��������һ������ͬ������
public class MyObject2 {

	private int i = 0;
	
	synchronized public void method1(){
		try {
			i = 50;
			System.out.println("ͬ��������ʼ" + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("ͬ������" + i);
			System.out.println("ͬ����������");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	
	 public void mehtod2(){
		i = 100;
		System.out.println("��ͬ��������ʼ" + Thread.currentThread().getName());
		System.out.println("��ͬ��������ʼ");
		System.out.println("��ͬ������" + i);
	}
}

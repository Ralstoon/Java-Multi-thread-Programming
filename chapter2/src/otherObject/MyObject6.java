package otherObject;

//�����쳣�����Զ��ͷ�
public class MyObject6 {

	synchronized public void method1(){
		if(Thread.currentThread().getName().equals("a")){
			System.out.println("a�߳̿�ʼ���쳣");
			System.out.println("�׳��쳣��ʱ����" + System.currentTimeMillis());
			int i = 0/0;//�׳��쳣
			System.out.println("�׳��쳣�ˣ�b�߳�ִ���ˣ���һ����Ӧ�ÿ�������");
		} else {
			System.out.println("�߳�" + Thread.currentThread().getName() + "������,��ǰʱ����" + System.currentTimeMillis());
		}
	}
	
	
}

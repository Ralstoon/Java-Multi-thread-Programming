package otherObject2;

//ͬ��synchronized�������޵ȴ�����
public class ObjectO {
	
	synchronized public void methodA(){
		System.out.println("����A��ʼ" + "��ǰ���߳���" + Thread.currentThread().getName());
		boolean falg = true;
		while(falg){
			//����������ѭ����
		}
		System.out.println("����A����" + "��ǰ�߳���" + Thread.currentThread().getName());
	}
	
	synchronized public void methodB(){
		System.out.println("����B��ʼ" + "��ǰ���߳���" + Thread.currentThread().getName());
		System.out.println("����B����" + "��ǰ���߳���" + Thread.currentThread().getName());
	}
	
}

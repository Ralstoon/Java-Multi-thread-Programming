package otherObject2;

//ʹ��new Object()����Ϊͬ�������Ķ���
public class ObjectN {

	public void methodA(Object object){
		try {
			synchronized (object) {
				//����������޵�ѭ��
				while(true){
					System.out.println("���뵱ǰ���߳�������" + Thread.currentThread().getName());
					Thread.sleep(500);
					System.out.println("�˳���ǰ���߳�������" + Thread.currentThread().getName());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

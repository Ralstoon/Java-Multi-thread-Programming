package otherObject2;

//��������String�ĳ���������(2):synchronizedͬ�����ʹ��
public class ObjectM {

	public void methodA(String string){
		try {
			synchronized (string) {
				while(true){
					System.out.println("��ǰ���߳�������" + Thread.currentThread().getName());
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

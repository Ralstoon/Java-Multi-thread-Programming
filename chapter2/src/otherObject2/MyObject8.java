package otherObject2;

//�����������Ϊ��������������������������ͬһ������
public class MyObject8 {

	public void methodA(){
		String anything = new String();//�ڷ����ڲ�����ľ���˽�б�����û���÷���һ�ζ����½�һ���µĶ�������������д����������濴һ��Ч��
		synchronized (anything) {
			try {
				System.out.println(Thread.currentThread().getName() + "�߳̽���" + "��ǰʱ����" + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + "�߳��˳�" + "��ǰʱ����" + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

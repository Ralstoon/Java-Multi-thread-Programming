package otherObject2;

//�������߳�ִ��x���󷽷������synchronized(this)������ʱ��Ҳ�ǳ���ͬ����ЧЧ��
public class ObjectH {

	public void methodA(){
		synchronized (this) {
			try {
				System.out.println("���뵱ǰ��ϵͳʱ����" + System.currentTimeMillis() + "��ǰ���߳���" + Thread.currentThread().getName());
				Thread.sleep(500);
				System.out.println("�˳���ǰ��ϵͳʱ����" + System.currentTimeMillis() + "��ǰ��ʱ����" + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

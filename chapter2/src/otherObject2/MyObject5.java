package otherObject2;

//�����������Ϊ���������
public class MyObject5 {

	private String username;
	private String password;
	
	private String anything = new String();
	
	public void methodA(){
		try {
			//����this����
			synchronized (anything) {
				System.out.println("�߳�" + Thread.currentThread().getName() + "�����˴����" + "��ǰʱ��Ϊ" + System.currentTimeMillis());
				Thread.sleep(1000);
				System.out.println("�߳�" + Thread.currentThread().getName() + "�뿪�˴����" + "��ǰʱ��Ϊ" + System.currentTimeMillis());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
}

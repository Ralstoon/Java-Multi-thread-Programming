package otherObject;

//ʵ�������ķ��̰߳�ȫ
public class HasPrivateNum {
	
	private int i = 0;
	
	//���ϸùؼ��־Ϳ���ʵ���̰߳�ȫ�ˣ�ȥ��synchronized����Ч��
	synchronized public void addUsername(String username) {
		try {
			if (username.equals("a")) {
				i = 50;
				System.out.println(username + "���" + i);
				Thread.sleep(1000);//���߳�����˯һ�ᣬ������ݵĳ���
				System.out.println(username + "���" + i);
			} else {
				 i = 100;
				 System.out.println(username + "���" + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

package otherObject;

//���
public class PublicVar {

	private String username = "A";
	private String password = "AA";
	
	synchronized public void setValue(String username,String password){
		try {
			System.out.println("��ǰ�߳�:" + Thread.currentThread().getName());
			this.username = username;
			Thread.sleep(100);//��һ���̴߳���ֵ����username�����˸�ֵ�����ǻ�û�ж�password���и�ֵ���ͱ���һ�̵߳���getValue����ȡֵ��
			this.password = password;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//��ȡֵ�ķ�������synchronized�Ͳ�������������synchronizedȥ������Ч��
	synchronized public void getValue(){
		System.out.println("��ǰ�߳�:" + Thread.currentThread().getName());
		System.out.println("username=" + username + "password" +  password);
	}
	
}

package otherObject;

//�����ڲ�����һ���������ǲ�����"���̰߳�ȫ"�����
public class HasSelfPrivateNum {

	public void addI(String username){
		//����������ڷ�������ģ�ÿ�������Ƕ�һ�޶���ӵ�У����Բ�����"���̰߳�ȫ"����
		int num = 0;
		if(username.equals("a")){
			num = 50;
			System.out.println("a��ã�num��ֵ��" + num);
		} else{
			num = 100;
			System.out.println("other��ã�num��ֵ��" + num);
		}
	}
}

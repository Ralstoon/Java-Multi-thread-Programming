package mythread3;

//ʹ��return��interrupt��ֹͣ�߳�
public class MyThread4 extends Thread {
	 
	@Override
	public void run() {
		for(int i=0; i < 5000; i++){
			if(this.interrupted()){	//interrupted()�����ж��߳��Ƿ��ж�
				System.out.println("�߳�ֹͣ");
				return;
			}
			System.out.println(i+1);
		}
		System.out.println("�������̻߳�û�б�ֹͣ ");
	}

}

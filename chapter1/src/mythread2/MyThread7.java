package mythread2;

//��ֹͣ���߳�:�쳣��
public class MyThread7 extends Thread {
	
	@Override
	public void run() {
		try {
			for(int i=0; i<500000; i++){
				if(this.interrupted()){//����interrupted()�������Դ�һ����ǣ����Ǳ�Ǹ��߳��Ѿ�ֹͣ��
					System.out.println("�߳��Ѿ��жϣ���Ҫ�˳�");
//				break;//����ֻ������forѭ��������û���ж��߳�
					throw new InterruptedException();//�����׳��쳣���ж��̣߳�����forѭ������Ĵ���Ͳ���ִ����
				}
				System.out.println("i=" + (i+1));
			}
		System.out.println("����for���棬������У�֤���̲߳�û��ֹͣ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

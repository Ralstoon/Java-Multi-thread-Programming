package mythread3;

/*	stop()�������쳣
 * 		���׳�java.lang.ThreadDeath�쳣
 * 	�Լ��ͷ����Ĳ������
 *		stop()��������ǿ�� ���߳�ֹͣ��������ʹһЩ����Ĺ����ò�����ɣ���һ��������Ƕ������Ķ������"����"���������ݳ�������
 */
public class MyThread2 extends Thread {
	
	@Override
	public void run() {
		try {
			this.stop();
		} catch (ThreadDeath e) {
			System.out.println("�׳��쳣");
			e.printStackTrace();
		}
	}

}

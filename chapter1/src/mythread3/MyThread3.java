package mythread3;

import other.synchronizedObject.SynchronizedObject;

/*	stop()�������쳣
 * 		���׳�java.lang.ThreadDeath�쳣
 * 	�Լ��ͷ����Ĳ������
 *		stop()��������ǿ�� ���߳�ֹͣ��������ʹһЩ����Ĺ����ò�����ɣ���һ��������Ƕ������Ķ������"����"���������ݳ�������
 */
public class MyThread3 extends Thread {
	
	private SynchronizedObject object;
	
	@Override
	public void run() {
		super.run();
		object.printString("b","bb");
	}

	public MyThread3(SynchronizedObject object) {
		super();
		this.object = object;
	}
}

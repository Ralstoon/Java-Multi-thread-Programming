package mythread2;

/*
 * ��������:
 * 		1.this.interrupted():���Ե�ǰ�߳��Ƿ��Ѿ��ж�
 * 		2.this.isInterrupted():�����߳��Ƿ��Ѿ��ж�
 * 
 * 		1.���Ե�ǰ�߳���ָ����this.interruptes()��δ�����߳�
 * 		�÷����������� public static boolean interrupted()
 * 
 * 		2.isInterrupted()����
 * 		�÷���������:public boolean isInterrupted();���Կ����÷���������static
 * 
 */
public class MyThread6 extends Thread {
	
 	public void run() {
		super.run();
		for(int i=0; i < 500000; i++){
			System.out.println("i=" + (i+1));
		}
	}  

}

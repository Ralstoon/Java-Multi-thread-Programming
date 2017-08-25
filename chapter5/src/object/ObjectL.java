package object;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * ����schedule(TimerTask task,long delay)�Ĳ���
 * 	 �÷�������������ִ��schedule(TimerTask task,long delay)������ǰʱ��Ϊ�ο�ʱ�䣬�ڴ˻������ӳ�ָ���ĺ�������ִ��һ������
 */
public class ObjectL {
	
	static public class MyTask extends TimerTask {
		public void run() {
			System.out.println("�����ˣ�ʱ��Ϊ" + new Date());
		}
	}
	
	public static void main(String[] args) {
		MyTask myTask = new MyTask();
		Timer timer = new Timer();
		System.out.println("��ǰ��ʱ����" + new Date().toLocaleString());
		timer.schedule(myTask, 5000);
	}

}

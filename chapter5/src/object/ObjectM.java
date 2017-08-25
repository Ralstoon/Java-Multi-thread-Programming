package object;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * ����schedule(TimerTask task,long delay,long period)��
 * 	�÷����������� ��ִ�и÷����ĵ�ǰʱ��Ϊ�ο������ڴ�ʱ��Ļ������ӳ�ָ���ĺ�����������ĳһ���ʱ������������ִ��ĳһ����
 */
public class ObjectM {

	static public class MyTask extends TimerTask {
		public void run() {
			System.out.println("�����ˣ�ʱ��Ϊ" + new Date());
		}
	}
	
	public static void main(String[] args) {
		MyTask myTask = new MyTask();
		Timer timer = new Timer();
		System.out.println("��ǰ��ʱ����" + new Date());
		
		timer.schedule(myTask, 3000, 5000);//�ڶ��������Ǽ����ִ�У�������������ÿ������ִ��һ��
	}
}

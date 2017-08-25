package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//Timer��cancel()������ע������:��ʱ��ʹ�ø÷�����һ����ֹͣ���񣬶�������ִ��
public class ObjectJ {
	
	static int i = 0;
	
	static public class MyTask extends TimerTask {
		public void run() {
			System.out.println("����ִ��" + i);
		}
	}
	
	public static void main(String[] args) throws ParseException {
		while (true) {
			i++;
			Timer timer = new Timer();
			MyTask myTask = new MyTask();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2017-07-29 00:57:00";
			Date date = sdf.parse(dateString);
			
			timer.schedule(myTask, date);
			timer.cancel();
			/*
			 * ��˵����Timer���е�cancel()������ʱ��û��������queue����
			 * 	����TimerTask���������������ִ��
			 */
		}
	}
	
}

package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//TimerTask���cancel()����
public class ObjectH {
	
	static public class MyTask extends TimerTask {
		public void run() {
			System.out.println("������MyTask��ʱ��Ϊ" + new Date());
		}
	}
	
	static public class MyTask2 extends TimerTask {
		public void run() {
			System.out.println("������MyTask2��ʱ��Ϊ" + new Date());
			this.cancel();
		}
	}
	
	

	public static void main(String[] args) throws ParseException {
		MyTask myTask1 = new MyTask();
		MyTask2 myTask2 = new MyTask2();//���������cancel()����
		
		//����һ��ʱ��
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString1 = "2017-07-29 00:39:00";
		String dateString2 = "2017-07-29 00:39:01";
		Date date1 = sdf1.parse(dateString1);
		Date date2 = sdf2.parse(dateString2);
		
		//����һ����ʱ��
		Timer timer = new Timer();
		timer.schedule(myTask1, date1, 1000);
		timer.schedule(myTask2, date2, 1000);
		/*
		 * TimerTask���cancel()�������������������б��Ƴ�������������Ӱ��
		 */
	}
}

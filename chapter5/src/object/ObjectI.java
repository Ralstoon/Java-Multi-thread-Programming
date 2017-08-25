package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//Timer���cancel()����:��TimerTask�еĲ�ͬ��Timer���е������ǽ���������е�ȫ���������
public class ObjectI {

	private static Timer timer = new Timer();
	
	static public class MyTask1 extends TimerTask {
		public void run() {
			System.out.println("�����ˣ�ʱ��Ϊ" + new Date());
			timer.cancel();
		}
	}
	
	static public class MyTask2 extends TimerTask{
		public void run() {
			System.out.println("�����ˣ�ʱ��Ϊ" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask1 myTask1 = new MyTask1();
		MyTask2 myTask2 = new MyTask2();
		
		//����һ��ʱ��
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString1 = "2017-07-29 00:49:00";
		String dateString2 = "2017-07-29 00:49:01";
		Date date1 = sdf1.parse(dateString1);
		Date date2 = sdf2.parse(dateString2);
			
		timer.schedule(myTask1, date1, 1000);
		timer.schedule(myTask2, date2, 1000);
		/*
		 * Timer���е�cancel()�����������ǽ���������е�ȫ���������
		 * 	ȫ��������������ҽ��̱����٣���ť��ɫ���ɫ
		 */
	}
	
}

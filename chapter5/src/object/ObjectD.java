package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//��Ϊǰ��������п������ĵ�ʱ��ϳ�����������������ʱ��Ҳ�ᱻ�ӳ�
public class ObjectD {

	private static Timer timer = new Timer();
	
	static public class MyTask1 extends TimerTask{
		public void run() {
			try {
				System.out.println("1��ʼ�ˣ�ʱ��Ϊ" + new Date());
				Thread.sleep(5000);
				System.out.println("1�����ˣ�ʱ��Ϊ" + new Date());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static public class MyTask2 extends TimerTask{
		public void run() {
			System.out.println("2�����ˣ�ʱ��Ϊ" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask1 myTask1 = new MyTask1();
		MyTask2 myTask2 = new MyTask2();
		
		//����һ��ʱ�����
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString1 = "2017-07-29 00:04:01";
		String dateString2 = "2017-07-29 00:04:02";		
		Date date1 = sdf1.parse(dateString1);
		Date date2 = sdf1.parse(dateString1);
		
		timer.schedule(myTask1, date1);
		timer.schedule(myTask2, date2);
		/*
		 * 	����myTask1��Ҫ5��ִ�����������Խ�ҪӰ��myTask2�ƻ�����ִ��ʱ�䣬
		 * 		myTask2�Դ�ʱ��Ϊ��׼������ӳ�5�롣
		 * 	��ΪTask�Ǳ��Ž������еģ���һ�������У��ȴ�myTask1���н������Ż��ֵ�myTask2���е�
		 */
	}
	
}

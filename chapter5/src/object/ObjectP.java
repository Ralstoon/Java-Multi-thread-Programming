package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import object.ObjectO.MyTask;

//��֤scheduleAtFixedRate��������׷��ִ����
public class ObjectP {
	
	private static Timer timer = new Timer();
	
	static public class MyTask extends TimerTask {
		public void run() {
			System.out.println("1��ʼ�����ˣ�ʱ��Ϊ" + new Date());
			System.out.println("1���������ˣ�ʱ��Ϊ" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask myTask = new MyTask();
		
		//����һ��ʱ�����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-07-29 13:26:00";
		Date date = sdf.parse(dateString);
		System.out.println("�ַ�����ʱ����" + date.toLocaleString() + "��ǰʱ����" + new Date().toLocaleString());
		timer.scheduleAtFixedRate(myTask, date, 5000);
		
	}

}

package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * ����schedule(TimerTask task,Date firstTime,long period)
 * 	�÷�������������ָ��������֮�󣬰�ָ���ļ�������Ե�����ѭ����ִ��ĳһ����
 * 		1.�ƻ�ʱ�����ڵ�ǰʱ��:��δ��ִ�е�Ч��
 */
public class ObjectE {

	static public class MyTask extends TimerTask{
		public void run() {
			System.out.println("�����ˣ�ʱ��Ϊ" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask myTask = new MyTask();
		
		//����һ��ʱ�����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-07-29 00:16:00";
		Date dateTime = sdf.parse(dateString);
				
		//����һ����ʱ��
		Timer timer = new Timer();
		timer.schedule(myTask, dateTime, 2000);
		/*
		 * �����еĽ��������Ҫ��ʱ����ʱ�䵽�ˣ�
		 * 	�ͻᰴ�ո�����ʱ����x�룬ÿ��x��ִ��һ��TimerTask���񣬲��������޵��ظ�ִ������
		 */
	}
}

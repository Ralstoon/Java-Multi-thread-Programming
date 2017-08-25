package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//�ƻ�ʱ�����ڵ�ǰʱ��:��ǰ���е�Ч��������ƻ�ʱ�����ڵ�ǰʱ�䣬������ִ������
public class ObjectF {


	static public class MyTask extends TimerTask{
		public void run() {
			System.out.println("�����ˣ���ǰ��ʱ����" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask myTask = new MyTask();
		
		//����һ��ʱ�����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-07-29 00:23:00";
		Date date = sdf.parse(dateString);
		
		//����һ����ʱ��
		Timer timer = new Timer();
		timer.schedule(myTask, date, 2000);
		/*
		 *	�ӿ���̨��ӡ�Ľ������
		 *		�������к�����ִ�� TimerTask����
		 * 
		 */
	}
	
}

package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//�ƻ�ʱ�����ڵ�ǰ��ʱ��:��ǰ���е�Ч�� �����ִ�������ʱ�����ڵ�ǰʱ�䣬������ִ������
public class ObjectB {
	
	private static Timer timer = new Timer();
	
	//�����Ƕ���һ����ʱ����ʱ�䵽�ͻ�ִ��run����ķ�����
	static public class MyTask extends TimerTask {

		public void run() {
			System.out.println("�����ˣ�ʱ��Ϊ" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask task = new MyTask();
		
		//����һ��ʱ�����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-7-28 23:39:00";
		Date dateRef = sdf.parse(dateString);
		System.out.println("�ַ�����ʱ����" + dateRef.toLocaleString() + "��ǰ��ʱ����" + new Date().toLocaleString());
		
		//����һ����ʱ������
		timer.schedule(task, dateRef);
		/*
		 * ���ִ�������ʱ�����ڵ�ǰʱ�䣬������ִ��task����
		 */
	}
	

}

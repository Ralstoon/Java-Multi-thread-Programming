package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//ִ�������ʱ�����ڵ�ǰ��ʱ��:��δ��ִ�е�Ч��
public class ObjectA {
	
	private static Timer timer = new Timer();//��true�Ž� Timer()�о����ػ��߳���
	
	static public class MyTask extends TimerTask{

		@Override
		public void run() {
			System.out.println("�����ˣ�ʱ��Ϊ:" + new Date() );
		}
	}
	
	public static Timer getTimer(){
		return timer;
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask task = new MyTask();
		
		//�����Ƕ���һ��ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-07-28 22:41:00";
		Date dateRef = sdf.parse(dateString);
		System.out.println("�ַ���ʱ��:" + dateRef.toLocaleString() + "��ǰʱ��" + new Date().toLocaleString());
		
		//����������ļ���������Ҫ����������һ���Ǽ̳���TimerTask��ʵ���࣬һ��������
		timer.schedule(task, dateRef);
		/*
		 * �������к���̻�û�����٣�Ϊʲô��������������
		 * 	Timer�Ĺ���ŷ�����
		 * 		public Timer(String name){
		 * 			thread.setName(name);
		 * 			thread.start();
		 * 		}
		 * 	
		 * 	�鿴���췽������֪��������һ��Timer��������һ���µ��̣߳�������������̲߳������ػ��̣߳���һֱ������	
		 * 
		 * 	��һ�����´�����Timer�ĳ��ػ��߳�
		 * 
		 */
	}
	
}

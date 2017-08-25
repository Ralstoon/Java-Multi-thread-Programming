package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//���TimerTask������ʱ�Ĳ���
public class ObjectC {

	private static Timer timer = new Timer();
	
	static public class MyTask1 extends TimerTask{
		public void run() {
			System.out.println("������ ʱ��Ϊ" + new Date());
		}
	}
	
	static public class MyTask2 extends TimerTask{
		public void run() {
			System.out.println("������ ʱ��Ϊ" + new Date());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask1 task1 = new MyTask1();
		MyTask2 task2 = new MyTask2();
		
		//����һ��ʱ�����
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString1 = "2017-07-28 23:48:00";
		String dateString2 = "2017-07-28 23:47:00";
		Date dateRef1 = sdf1.parse(dateString1);
		Date dateRef2 = sdf2.parse(dateString2);
		System.out.println("�ַ���һ��ʱ����" + dateRef1.toLocaleString() + "��ǰ��ʱ����" + new Date().toLocaleString());
		System.out.println("�ַ�������ʱ����" + dateRef2.toLocaleString() + "��ǰ��ʱ����" + new Date().toLocaleString());
		
		//����һ����ʱ��
		timer.schedule(task1, dateRef1);
		timer.schedule(task2, dateRef2);
		/*
		 * 	TimerTask����   ���еķ�ʽ   һ��һ����˳��ִ�еģ�����ִ�е�ʱ���п��ܺ�Ԥ�ڵ�ʱ�䲻һ��
		 * 		��Ϊǰ��������п������ĵ�ʱ��ϳ�����������������ʱ��Ҳ�ᱻ�ӳ�
		 */
	}
	
}

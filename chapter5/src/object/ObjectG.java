package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//����ִ�е�ʱ�䱻�ӳ�
public class ObjectG {
	
	static public class MyTask extends TimerTask {
		public void run() {
			try {
				System.out.println("�����ˣ���ǰʱ��Ϊ" + new Date());
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws ParseException {
		MyTask myTask = new MyTask();
		
		//����һ��ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "2017-07-29 00:30:00";
		Date date = sdf.parse(dateString);
		
		//����һ��������
		Timer timer = new Timer();
		timer.schedule(myTask, date, 1000);
		/*
		 * �����ӳ��ˣ�������һ��һ����ִ��
		 */
	}

}

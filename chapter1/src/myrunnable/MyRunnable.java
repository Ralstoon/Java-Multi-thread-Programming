package myrunnable;

//ʵ��runnable�ӿڣ�����һ�����߳��ࡣ��һ�����Ѿ���һ�������ˣ���ʱ��Ͳ���ֱ��ʹ�ü̳�Thread����������һ���µ��̣߳�java��֧�ֶ�̳У�����Ҫʵ��runnable�ӿ�
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("running");
	}

}

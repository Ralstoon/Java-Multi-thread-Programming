package otherObject2;

import java.util.Iterator;

public class ObjectAC extends Thread {
	
	volatile public static int count;
	private static void addCount(){
		//����İ취�������������ͬ�������
		for(int i=0; i<100; i++){
			count++;
		}
		System.out.println("count" + count);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		this.addCount();
	}

}

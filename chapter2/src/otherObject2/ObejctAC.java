package otherObject2;
//volatile�ؼ���(4):ʹ��volatile�ؼ���
public class ObejctAC extends Thread {
	
	volatile private boolean isRunning = true;
	public boolean isRunning(){
		return isRunning;
	}
	
	public void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("������run����");
		while (isRunning) {
			//����������޵�ѭ��
		}
		System.out.println("�̱߳�ֹͣ��");
	}
}

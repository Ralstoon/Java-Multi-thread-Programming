package otherObject2;
//volatile�ؼ���(3):���ͬ����ѭ��
public class ObjectAA extends Thread {

	private boolean isRunning = true;
	
	private boolean isRunning(){
		return isRunning;
	}
	
	public void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		System.out.println("����run��");
		while (isRunning == true) {
			//���������޵�ѭ��
		}
		System.out.println("�̱߳�ֹͣ��");
	}
	
}

package otherObject2;

//volatile�ؼ���(1):�޷�ֹͣ���߳�
public class ObjectY {

	private boolean isContinuePrint = true;
	private boolean isContinuePrint(){
		return isContinuePrint;
	}
	public void setContinuePrint(boolean isContinuePrint) {
		this.isContinuePrint = isContinuePrint;
	}
	
	public void printStringMethod(){
		try {
			while(isContinuePrint){
				System.out.println("��ǰ���߳���" + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

package otherObject2;
//volatile�ؼ���(2):���ͬ����ѭ��
public class ObjectZ implements Runnable{

	private boolean isContinue = true;
	
	public boolean isContinue(){
		return isContinue;
	}
	
	public void setContinue(boolean isContinue) {
		this.isContinue = isContinue;
	}


	public void printStringMethod(){
		try {
			while (isContinue) {
				System.out.println("��ǰ���߳���" + Thread.currentThread().getName());
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.printStringMethod();
	}
	

}

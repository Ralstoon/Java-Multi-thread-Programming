package otherObject2;
//synchronized�������volatileͬ������(1):ͣ���µ�ѭ��
public class ObjectAE {

	private boolean isContinue = true;
	
	public void runMethod(){
		while (isContinue) {
			//����������ѭ��
//			synchronized ("��") {
//			}
		}
		System.out.println("ͣ������");
	}
	
	public void stopMethod(){
		isContinue = false;
	}
}

package otherObject2;

//ֻҪ�Ƕ���û�иı䣬��ʹ�Ƕ�������Է����ı䣬���еĽ������ͬ����
public class ObjectW {
	
	public void methodA(ObjectX objectX){
		synchronized (objectX) {
			try {
				System.out.println(Thread.currentThread().getName());
				objectX.setUsername("abc");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "�߳��˳�");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}

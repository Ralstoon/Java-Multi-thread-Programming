package otherObject2;

//ͬ�������ı׶�
public class MyObject1 {

	private String getData1;
	private String getData2;
	
	 public void doLongTimeTask(){
		try {
			System.out.println("begin task");
			Thread.sleep(3000);
			synchronized(this){
				getData1 = "��ʱ�䴦��������Զ�̷��ص�ֵ   ���̵߳�������" + Thread.currentThread().getName();
				getData2 = "��ʱ�䴦��������Զ�̷��ص�ֵ  ���̵߳�������" + Thread.currentThread().getName();
			}
			System.out.println(getData1);
			System.out.println(getData2);
			System.out.println("end task");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

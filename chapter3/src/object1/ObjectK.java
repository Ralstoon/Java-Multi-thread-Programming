package object1;

//�̱߳���
public class ObjectK {
	
	public static ThreadLocal t1 = new ThreadLocal();
	
	public void test(){
		if (t1.get() == null) {
			System.out.println("��δ�Ź�ֵ");
			t1.set("�ҵ�ֵ");
		}
		System.out.println(t1.get());
	}
	
}

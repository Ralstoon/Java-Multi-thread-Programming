package object;

//ʹ�þ�̬������ʵ�ֵ���ģʽ
public class ObjectD {
	
	private static class ObjectDHandler {
		private static ObjectD objectD = new ObjectD();
	}
	
	private ObjectD(){}
	
	public static ObjectD getInstance(){
		return ObjectDHandler.objectD;
	}
}

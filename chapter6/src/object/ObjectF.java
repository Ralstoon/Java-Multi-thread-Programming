package object;

//ʹ�þ�̬static�����ʵ�ֵ���ģʽ
public class ObjectF {
	
	private static ObjectF objectF = null;
	
	private ObjectF(){}
	
	static {
		objectF = new ObjectF();
	}
	
	public static ObjectF getIntance(){
		return objectF;
	}
}

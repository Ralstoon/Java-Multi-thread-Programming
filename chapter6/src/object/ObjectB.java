package object;

//��ʱ����/"����ģʽ"
public class ObjectB {

	private static ObjectB objectB;
	
	private ObjectB(){}
	
	public static ObjectB getInstance(){
		//��ʱ����
		if (objectB == null) {
			objectB = new ObjectB();
		}
		return objectB;
	}
	
}

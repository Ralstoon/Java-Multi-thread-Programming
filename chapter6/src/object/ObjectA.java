package object;

//��������/"����ģʽ"
public class ObjectA {

	private static ObjectA objectA = new ObjectA();
	
	private ObjectA(){
	}

	public static ObjectA getInstance(){
		return objectA;
	}
}


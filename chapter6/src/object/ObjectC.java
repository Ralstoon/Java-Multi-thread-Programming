package object;

//ʹ��DCL˫��������� ��ʵ�ֶ��̻߳����е���ʱ���ص������ģʽ
public class ObjectC {
	
	private volatile static ObjectC objectC;
	
	private ObjectC(){}
	
	public static ObjectC getInstance(){
		if (objectC != null) {
			/*
			 * ����ʹ����volatile�ؼ��֣����е��߳��ǿɼ���
			 * 	ֻҪһ������objectC�������Ͳ����������synchronized����飬�����ʹ��������Ч��
			 */
		} else {
			synchronized (ObjectC.class) {
				if(objectC == null){
					objectC = new ObjectC();
				}
			}
		}
		return objectC;
	}
	
}

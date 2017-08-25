package object;

import java.io.Serializable;

//���л��뷴���л��ĵ���ģʽʵ��
public class ObjectE implements Serializable {
	
	private static final long serialVersionUID = 888L;
	
	//�ڲ��෽ʽ
	private static class ObjectEHandler{
		private static final ObjectE objectE = new ObjectE();
	}
	
	private ObjectE(){}
	
	public ObjectE getInstance(){
		return ObjectEHandler.objectE;
	}
	
}

package object1;
//ʵ�ֵ�һ�ε���ThreadLocal���get()��������ֵ����null
public class ObjectM extends ThreadLocal {
	
	protected Object initialValue(){
		return "��ҪĬ��ֵ����һ��get������null";
	}

}

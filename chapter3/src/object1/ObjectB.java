package object1;

import java.util.ArrayList;
import java.util.List;

//ʹ��wait��notifyʵ��ǰ���  ����Ԫ�ص���5��ʱ��һ���߳��˳�
public class ObjectB {
	
	private List list = new ArrayList();
	
	public void add(){
		list.add("Ī����");
	}
	
	public int getSize(){
		return list.size();
	}
}

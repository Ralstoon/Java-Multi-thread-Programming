package object1;

import java.util.ArrayList;
import java.util.List;

//��ʹ�õȴ�/֪ͨ����ʵ���̼߳��ͨ��
public class ObjectA {
	
	volatile private List list = new ArrayList();
	
	public void add(){
		list.add("Ī����");
	}
	
	public int size(){
		return list.size();
	}
	
}

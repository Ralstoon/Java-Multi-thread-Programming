package otherObject2;

import java.util.ArrayList;
import java.util.List;

//���List����ֻ��һ��Ԫ��
public class ObjectB {
	private List list = new ArrayList();
	
	synchronized public void add(String data){
		list.add(data);
	}
	
	synchronized public int getSize(){
		return list.size();
	}
}

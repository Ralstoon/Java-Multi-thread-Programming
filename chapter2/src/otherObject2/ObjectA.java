package otherObject2;

import java.util.ArrayList;
import java.util.List;

//����̵߳���ͬһ�������������
public class ObjectA {
	
	private List list = new ArrayList();
	
	synchronized public void add(String username){
		System.out.println("��ǰ�̵߳�����" + Thread.currentThread().getName() + "ִ����add����");
		System.out.println("��ǰ�̵߳�����" + Thread.currentThread().getName() + "�뿪��add����");
	}
	
	synchronized public int getSize(){
		System.out.println("��ǰ�̵߳�����" + Thread.currentThread().getName() + "ִ����getSize����");
		int sizeValue = list.size();
		System.out.println("��ǰ�̵߳�����" + Thread.currentThread().getName() + "�˳���getSize����");
		return sizeValue;
	}

}

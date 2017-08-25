package object1;

import java.util.ArrayList;
import java.util.List;

public class ObjectH {

	private List list = new ArrayList();
	
	synchronized public void push(){
		try {
			if (list.size() == 1) {
				this.wait();
			}
			list.add("anyString" + Math.random()); 
			this.notify();
			System.out.println("push=" + list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	synchronized public String pop(){
			String value = "";
		try {
			if (list.size() == 0) {
				System.out.println("pop�����е�:" + Thread.currentThread().getName() + "�̳߳�wait״̬");
				this.wait();
			}
			value = "" + list.get(0);
			list.remove(0);
			this.notify();
			System.out.println("pop" + list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return value;
	}
}

package otherObject;

//���������ĸ�����̳�
public class MyObject5 extends MyObject4{
	
	synchronized public void methodSon(){
		while(i > 0){
			i--;
			System.out.println("methodSon  i=" + i);
			this.methodFather();//this������ģ�ͣ�������ָ����ĵ��ǣ�����MyObject4
		}
	}
	
}

package otherObject2;

//���List����ֻ��һ��Ԫ�ص�
public class ObjectC {
	public ObjectB addServiceMethod(ObjectB list,String data){
		try {
			synchronized (list) {
				if(list.getSize() < 1){
					Thread.sleep(2000);//ģ���Զ�̻���2��ȡ������
					list.add(data);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}

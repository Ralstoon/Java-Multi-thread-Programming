package otherObject2;

//˽�б������̰߳�ȫ
public class MyObject7 {

	public void methodA(){
		try {
			int j = 8;
			if(Thread.currentThread().getName().equals("a")){
				j = 7;
				Thread.sleep(3000);
			} else {
				j = 6;
			}
			System.out.println("���߳�" + Thread.currentThread().getName() + "��ӡj��ֵΪ=" + j);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

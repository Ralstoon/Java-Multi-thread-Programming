package otherObject2;

//��������ͬ����ʵ��1:��������������ͬ����������ʹ�õ�ȴ�ǲ�ͬ��������ӡ�Ľ��Ҳ���첽��
public class ObjectT {
	public static class classA{
		public void methodA(){
			synchronized ("��������") {
				try {
					for (int i = 0; i < 50; i++) {
						System.out.println(Thread.currentThread().getName() + "�߳̽���A����" + "i��ֵ��" + i);
						Thread.sleep(100);

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		synchronized public void methodB(){
			try {
				for (int i = 0; i < 50; i++) {
					System.out.println(Thread.currentThread().getName() + "�߳̽���B����" + "i��ֵ��" + i);
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

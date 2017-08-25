package otherObject2;

public class ObjectU {

	public static class ClassB{
		
		public void methodA(ClassC classC){
			String threadName = Thread.currentThread().getName();
			synchronized (classC) {
				System.out.println(threadName + "����ClassB�е�methodA����" );
				for (int i = 0; i < 10; i++) {
					System.out.println("i=" + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println(threadName + "�˳�ClassB�е�methodA����" );
		}
		
		public synchronized void methodB()  {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + "����ClassB�е�methodB����" );
			for (int i = 0; i < 10; i++) {
				System.out.println("i=" + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName + "�˳�ClassB�е�methodB����" );
		}
	}
	
	public static class ClassC{
		public synchronized void methodB(){
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + "����ClassC�е�methodB����" );
			for (int i = 0; i < 10; i++) {
				System.out.println("i=" + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName + "�˳�ClassC�е�methodB����" );

		}
	}
	
}

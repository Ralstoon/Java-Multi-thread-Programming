package test;

import object.ObjectA;
import object.ObjectB;
import object.ObjectC;
import object.ObjectD;
import object.ObjectF;
import object.ObjectG;

import org.junit.Test;

public class Test1 {
	
	
	//���潲�ľ��ǵ���ģʽ
	
	//��������/"����ģʽ"
	@Test
	public void singleton(){
		Thread thread = new Thread(){
			public void run() {
				System.out.println(ObjectA.getInstance().hashCode());
			}
		};
		Thread thread2 = new Thread(){
			public void run() {
				System.out.println(ObjectA.getInstance().hashCode());
			}
		};
		Thread thread3 = new Thread(){
			public void run() {
				System.out.println(ObjectA.getInstance().hashCode());
			}
		};
		
		thread.start();
		thread2.start();
		thread3.start();
		/*
		 * ��������/����ģʽ������ʹ�����ʱ���Ѿ������󴴽����
		 * 		�ӿ���̨��ӡ��hashCode��ͬһ��ֵ��˵���������ͬһ����Ҳ����ʵ���˵������ģʽ
		 */
	}
	
	
	//��ʱ����/"����ģʽ"
	@Test
	public void singleton_1(){
		Thread thread = new Thread(){
			public void run() {
				System.out.println(ObjectB.getInstance().hashCode());
			}
		};
		thread.start();
		Thread thread2 = new Thread(){
			public void run() {
				System.out.println(ObjectB.getInstance().hashCode());
			}
		};
		thread2.start();
		Thread thread3 = new Thread(){
			public void run() {
				System.out.println(ObjectB.getInstance().hashCode());
			}
		}; 
		thread3.start();
		/*
		 * �����Ļ����̼߳��س������ж������ģ���Ҫԭ���Ƕ���߳�ͬʱ����if��䣬�ʹ����˶������
		 * 	����İ취��getInstance()������synchronized�Ļ��ǿ��Եã�����Ч��̫����
		 * 		��һ�־���ʹ��DCL˫���������
		 */
	}
	
	
	//ʹ��DCL˫���������
	@Test
	public void singleton_2(){
		
		Thread thread = new Thread(){
			public void run() {
				System.out.println(ObjectC.getInstance().hashCode());
			}
		};
		thread.start();
		
		Thread thread2 = new Thread(){
			public void run() {
				System.out.println(ObjectC.getInstance().hashCode());
			}
		};
		thread2.start();
		
		Thread thread3 = new Thread(){
			public void run() {
				System.out.println(ObjectC.getInstance().hashCode());
			}
		};
		thread3.start();
		/*
		 * ʹ��˫�ؼ�������ܡ��ɹ��ؽ����"����ģʽ"�������̵߳����⡣
		 * 	DCLҲ�Ǵ�������߳̽�ϵ���ģʽʹ�õĽ������
		 */
	}
	
	
	//ʹ�þ�̬������ʵ�ֵ���ģʽ
	@Test
	public void singleton_3(){
		
		Thread thread = new Thread(){
			public void run() {
				System.out.println(ObjectD.getInstance().hashCode());
			}
		};
		thread.start();
		
		Thread thread2 = new Thread(){
			public void run() {
				System.out.println(ObjectD.getInstance().hashCode());
			}
		};
		thread2.start();
		
		Thread thread3 = new Thread(){
			public void run() {
				System.out.println(ObjectD.getInstance().hashCode());
			}
		};
		thread3.start();
	}
	
	
	
	//���л��뷴���л��ĵ���ģʽʵ��
	@Test
	public void singleton_4(){
		//���ﲻ�Ǻ�����
	}
	
	
	//ʹ�þ�̬static�����ʵ�ֵ���ģʽ
	@Test
	public void singleton_5(){
		
		Thread thread = new Thread(){
			public void run() {
				for (int i = 0; i < 6; i++) {
					System.out.println(ObjectF.getIntance().hashCode());
				}
			}
		};
		thread.start();
		
		Thread thread2 = new Thread(){
			public void run() {
				for (int i = 0; i < 6; i++) {
					System.out.println(ObjectF.getIntance().hashCode());
				}
			}
		};
		thread2.start();
		
		Thread thread3 = new Thread(){
			public void run() {
				for (int i = 0; i < 6; i++) {
					System.out.println(ObjectF.getIntance().hashCode());
				}
			}
		};
		thread3.start();
	}
	
	
	//ʹ��enumö����������ʵ�ֵ���ģʽ
	@Test
	public void singleton_6(){
		//���ﲻ�Ǻ�����,ΪʲôҪ�������ݿ�
	}
	
	
	
}
	
 
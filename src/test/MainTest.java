package test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainTest {

	static final CyclicBarrier barrier = new CyclicBarrier(4);

	public static void main(String[] args) throws InterruptedException {
		T1 t1 = new MainTest.T1();
		T2 t2 = new MainTest.T2();
		T3 t3 = new MainTest.T3();
		T4 t4 = new MainTest.T4();
		System.out.println("开始使用栅栏");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	static class T1 extends Thread {
		public void run() {
			while (true) {
				if (barrier.getNumberWaiting() == 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("A");
					try {
						barrier.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	static class T2 extends Thread {
		public void run() {
			while (true) {
				if (barrier.getNumberWaiting() == 1) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("B");
					try {
						barrier.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	static class T3 extends Thread {
		public void run() {
			while (true) {
				if (barrier.getNumberWaiting() == 2) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("C");
					try {
						barrier.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	static class T4 extends Thread {
		public void run() {
			while (true) {
				if (barrier.getNumberWaiting() == 3) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("D");
					try {
						barrier.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}
}

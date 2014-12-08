package org.jackey.study.concurrent.thread;

public class TestDeadLock {

	public static void main(String[] args) {
		Resource a = new Resource();
		Resource b = new Resource();
		DeadLock d1 = new DeadLock(a, b, "D1");
		DeadLock d2 = new DeadLock(a, b, "D2");
		DeadLock d3 = new DeadLock(a, b, "D3");
		DeadLock d4 = new DeadLock(a, b, "D4");
		DeadLock d5 = new DeadLock(a, b, "D5");
		d1.start();
		d2.start();
		d3.start(); 
		d4.start();
		d5.start();
	}

	static class Resource {
		private int value = 0;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	static class DeadLock extends Thread {
		private Resource resourceA;
		private Resource resourceB;
		private String name;

		public DeadLock(Resource resourceA, Resource resourceB, String name) {
			this.resourceA = resourceA;
			this.resourceB = resourceB;
			this.name = name;
		}

		public void read() {
			synchronized (resourceA) {
				System.out.println(name + " read get the lock of resourceA");
				synchronized (resourceB) {
					System.out
							.println(name + " read get the lock of resourceB");
					System.out.println("read A=" + resourceA.getValue()
							+ "  ,B=" + resourceB.getValue());
				}
			}
		}

		public void write(int a, int b) {
			synchronized (resourceB) {
				System.out.println(name + " write get the lock of resourceB");
				synchronized (resourceA) {
					System.out.println(name
							+ " write get the lock of resourceA");
					resourceA.setValue(a);
					resourceB.setValue(b);
					System.out.println("write A=" + resourceA.getValue()
							+ "  ,B=" + resourceB.getValue());
				}
			}
		}

		public void run() {
			read();
			write(1, 2);
		}

	}
}

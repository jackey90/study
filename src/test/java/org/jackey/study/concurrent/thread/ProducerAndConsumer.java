package org.jackey.study.concurrent.thread;

public class ProducerAndConsumer {
	
	public static void main(String[] args) {
		Repository repo = new Repository();
		Producer producer = new Producer(1000, repo, "jinge");
		Consumer consumer = new Consumer(1500, repo, "tongjie");
		repo.start();
		producer.start();
		consumer.start();
	}
	
	static class Repository extends Thread{
		private static final int MAX = 10000;
		private int currentNum= 0;

		public synchronized void produce(int num) {
			while (currentNum + num > MAX) {
				System.out.println("too much in the repository, please wait..");
				try {
					wait();
					System.out.println("produce wake up");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			currentNum += num;
			notifyAll();
		}

		public synchronized void consume(int num) {
			while (currentNum < num) {
				System.out
						.println("not enough int the repository. please wait..");
				try {
					wait();
					System.out.println("consume wake up");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			currentNum -= num;
			notifyAll();
		}
		
		public void run(){
			while(true){
				System.out.println("curent number :" + currentNum);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	static class Producer extends Thread {
		private int num;
		private Repository repo;
		private String name;

		public Producer(int num, Repository repo, String name) {
			this.num = num;
			this.repo = repo;
			this.name = name;
		}

		public void run() {
			while (true) {
				System.out.println("Producer " + name + " producing " + num);
				repo.produce(num);
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	static class Consumer extends Thread {
		private int num;
		private Repository repo;
		private String name;

		public Consumer(int num, Repository repo, String name) {
			this.num = num;
			this.repo = repo;
			this.name = name;
		}

		public void run() {
			while (true) {
				System.out.println("Consumer" + name + " consuming " + num);
				repo.consume(num);
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}
}

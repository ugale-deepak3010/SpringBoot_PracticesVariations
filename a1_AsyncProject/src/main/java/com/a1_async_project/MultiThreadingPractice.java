package com.a1_async_project;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultiThreadingPractice {
	
	private int count = 0;

	public  void increment() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
	

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {

		// Thread

		log.info("phase-1");

		Thread thread1 = new Thread();
		thread1.sleep(5_000); // 5 seconds

		log.info("phase-2");

		// ---------------------------------------------------------------

		Thread thread2 = new Thread(() -> {
			log.info("Running in different thread (Runnable) ");
		});
		thread2.run();

		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				log.info("Running in 3rd different thread");
			}
		};

		runnable1.run();

		// -----------------------------------------------------------------

	}



}

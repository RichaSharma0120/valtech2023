package com.valtech.training.day3;

import java.util.Iterator;

// any class which wants to implement threads needs to extend Thread class
// the it should override the run method

public class ThreadsTest {

	public static class PrinterThread extends Thread {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread() + " " + i);
			}

		}
	}
// ---------------------------------------
	// in the output
	// Thread[Thread-0,5,main] here 5 is thr priority of the thread, thread 0 is the
	// name of the thread and main is the group name
//--------------------------------------

	// --------
	public static class PrinterThreadByInterface implements Runnable {

		@Override
		public void run() {		// run is used to start the thread
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread() + " " + i);
			}

		}
	}

	public static void main(String[] args) {

		new PrinterThread().start();
		// every time we call new PrinterThread().start(); , a new thread is created
		new PrinterThread().start();
		//we can directly start the PrinterThread() because it is directly extending the Thread class so it is easy

		
		// now, PrinterThreadByInterface() doesn't extend Thread class directly but implements Runnable
		// so to create a thread and start it first we pass the object( created by new PrinterThreadByInterface() ) to thread and then start ir
		Thread t = new Thread(new PrinterThreadByInterface());
		t.start();
		//OR
		new Thread(new PrinterThreadByInterface()).start(); // creates the thread
		new Thread(new Runnable() { // to start the thread instead of creating the class separately, we pass Runnable method as inline method
									// i.e we write the method here only and override the run method.
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread() + " " + i);
				}

			}
		}).start();

		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread() + " " + i);
		}
	}
}

package com.thread;

/*
 * This prpgram illustrates the Synchronized keyword in a Java thread.
 * Only one thread can access the resource at a given point of time.
 * All other threads attempting to enter the synchronized block are blocked 
 * until the thread inside the synchronized block exits the block.
 */

public class MySynchronized  {

    private  int count = 0;
	
	/***************************************************************************************************************
	 * increment() is a synchronized block that increments the count variable, which is updated by multiple threads
	 ***************************************************************************************************************/
    public synchronized  void increment() {
		count++;
		//System.out.println(count);
	}
	
	

	/***************************************************************************************************************
	 * doWork() runs three threads and updates the count variable. The total count value is printed
	 ***************************************************************************************************************/
    private void doWork() {
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 10; i++) {
				
					increment();
					System.out.println(2*count);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}, "Rob's Thread");
		
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 10; i++) {
					
					increment();
					System.out.println(3*count);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}, "Luis's Thread");
		
	
		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 10; i++) {
					
					increment();
					System.out.println(4*count);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}, "Jimmy's Thread");
		
		thread1.start();
		thread2.start();
		//thread3.start();
		
		try {
			//the join() method prevents lines of code from running until the thread(s) have completed
			thread1.join();
			thread2.join();
			//thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Will not print out until all of the threads have been completed
		System.out.println("Count = " + count);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySynchronized mySynchronized = new MySynchronized();
		mySynchronized.doWork();
	}


	

}

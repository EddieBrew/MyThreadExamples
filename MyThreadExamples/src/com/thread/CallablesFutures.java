package com.thread;

import java.util.Random;
import java.util.concurrent.Callable;import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallablesFutures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	  for( int i = 0; i < 10; i++) {
		
			ExecutorService executor = Executors.newCachedThreadPool();
		
			Future<Integer> future = executor.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					
					    System.out.println("Starting....");
						Random random = new Random();
						int duration = random.nextInt(4000);
	
						
						try {
							Thread.sleep(duration);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Finished");
		
						return duration;
				}});
			executor.shutdown();
			
			try {
				System.out.println("Result is " + future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
  }

}

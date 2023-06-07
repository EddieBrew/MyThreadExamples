package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {


	
	public static  class Connection{
		private static Connection instance = new Connection();
		private Semaphore sem = new Semaphore(5, true);//number of available permits. Used to control access to some results
		private int  connections = 0;
		private Connection() {
			
		}
		private static  Connection getInstance() {
			return instance;
		}
		
		public void connect() {
			try {
				sem.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				doConnect();
			} finally {
				// TODO Auto-generated catch block
				sem.release();
			}
			
		}
		
		public void doConnect() {
			
			synchronized(this) {
				connections++;
				System.out.println("Current Connection: " + connections);
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(this) {
				connections--;
				System.out.println("Current Connection: " + connections);
			}
		}
		
	}//end Connection
	
	public static void main(String[] args) 
	{
		
		ExecutorService executor =Executors.newCachedThreadPool();
		for (int i = 0; i < 50; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
				
					Connection.getInstance().connect();
				}
			});
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread Processing Completed " );
		
	}
	

}

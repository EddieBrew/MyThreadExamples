package com.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
	
				List<Integer> array = new ArrayList<>();
				for(int i = 0; i < 23000; i++) {
					array.add(i);
				}
				
				System.out.println("total number of entries are " + array.size());
			}
			
		}, "Thread1");
		
		System.out.println(thread1.getName() + " has started.");
		thread1.start();
	
		

	}

}

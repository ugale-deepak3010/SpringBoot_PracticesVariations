package com.a1_async_project.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloService {

	// @Async methods must return void, 
	// or
	// Future<T>, CompletableFuture<T>, ListenableFuture<T>.

	public String getHuge_sync() {

		String output = "default message ";

		try {
			Thread.sleep(5000);
			output = "Sync process took 5 sec "; // hold the process
		} catch (Exception e) {
			return output + e.getMessage();
		}

		return output;
	}
	
	@Async
	public CompletableFuture<String> getHugeAsync() { // This method act like Async but code is blocking so it's sync {} 
		
		String output = "default message ";// 0 sec
		log.info("process started.");

		try {
			Thread.sleep(20_000);  // This is stil sync. // 20 sec
			output = "Process completed. Async process took 20 sec "; //
		} catch (Exception e) {
			output =e.getMessage();
		}
		return CompletableFuture.completedFuture(output); // 21 second. (hence it's sync. if it's return within 0,1,2 second withput blocking then it will be async)
	}
	
	
	
	//@Async
	public void testAsyncFireForget() {
	    //System.err.println("ASYNC FIRE: " + Thread.currentThread().getName()); // running in different thread not main thread!
		
		
	    
	    log.info("ASYNC FIRE: " + Thread.currentThread().getName());
	    try {
	        Thread.sleep(5000);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    //System.err.println("Done.");
	    
	    log.info("Done");
	}


}

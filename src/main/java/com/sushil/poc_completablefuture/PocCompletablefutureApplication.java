package com.sushil.poc_completablefuture;

import com.sushil.poc_completablefuture.model.Course;
import com.sushil.poc_completablefuture.model.Student;
import com.sushil.poc_completablefuture.service.CompletableFutureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class PocCompletablefutureApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocCompletablefutureApplication.class, args);
		CompletableFutureService completableFutureService = new CompletableFutureService();

		long syncStartTime = System.currentTimeMillis();
		System.out.println(" **** Start Synchronous Execution Time : "+syncStartTime +" ****");
//		completableFutureService.synchronousExecution();
		completableFutureService.synchronousExecution();
		long syncEndTime = System.currentTimeMillis();
		System.out.println("**** End Synchronous Execution Time : "+syncEndTime +" ****");
		System.out.println("**** Total Synchronous Execution Time: " + (syncEndTime - syncStartTime) + "ms"+ " ****");

		// Asynchronous Execution
		long asyncStartTime = System.currentTimeMillis();
		System.out.println("**** Start Asynchronous Execution Time : "+asyncStartTime+" ****");
		CompletableFuture<List<Student>> future1 = CompletableFuture.supplyAsync(() -> completableFutureService.getAllStudent());
		CompletableFuture<List<Course>> future2 = CompletableFuture.supplyAsync(() -> completableFutureService.getAllCourse());

		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
		combinedFuture.join();
		long asyncEndTime = System.currentTimeMillis();
		System.out.println("**** End Asynchronous Execution Time : "+asyncEndTime+" ****");

		System.out.println("**** Total Asynchronous Execution Time: " + (asyncEndTime - asyncStartTime) + "ms" +" ****");
	}
}

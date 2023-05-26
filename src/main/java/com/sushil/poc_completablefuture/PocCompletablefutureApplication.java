package com.sushil.poc_completablefuture;

import com.sushil.poc_completablefuture.model.Course;
import com.sushil.poc_completablefuture.model.Student;
import com.sushil.poc_completablefuture.service.CompletableFutureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class PocCompletablefutureApplication {
    private static final Logger logger = LoggerFactory.getLogger(PocCompletablefutureApplication.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(PocCompletablefutureApplication.class, args);

        String city = "Agra";
        CompletableFutureService completableFutureService = new CompletableFutureService();

        long syncStartTime = System.currentTimeMillis();
        logger.info(" **** Start Synchronous Execution Time : " + syncStartTime + " ****");
//		completableFutureService.synchronousExecution();
        completableFutureService.synchronousExecution(city);
        long syncEndTime = System.currentTimeMillis();
        logger.info("**** End Synchronous Execution Time : " + syncEndTime + " ****");
        System.out.println("**** Total Synchronous Execution Time: " + (syncEndTime - syncStartTime) + "ms" + " ****");

        // Asynchronous Execution
        long asyncStartTime = System.currentTimeMillis();
        logger.info("**** Start Asynchronous Execution Time : " + asyncStartTime + " ****");
        CompletableFuture<List<Student>> future1 = CompletableFuture.supplyAsync(() -> completableFutureService.getAllStudentByCity(city));

        CompletableFuture<List<Course>> future2 = CompletableFuture.supplyAsync(() -> completableFutureService.getAllCourse());

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
        combinedFuture.join();
        long asyncEndTime = System.currentTimeMillis();
        logger.info("**** End Asynchronous Execution Time : " + asyncEndTime + " ****");

        logger.info("**** Total Asynchronous Execution Time: " + (asyncEndTime - asyncStartTime) + "ms" + " ****");

    }
}

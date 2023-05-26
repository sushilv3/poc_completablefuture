
package com.sushil.poc_completablefuture.controller;

import com.sushil.poc_completablefuture.PocCompletablefutureApplication;
import com.sushil.poc_completablefuture.model.Course;
import com.sushil.poc_completablefuture.model.Student;
import com.sushil.poc_completablefuture.service.CompletableFutureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/completableFuture")
public class CompletableFutureController {
    private static final Logger logger = LoggerFactory.getLogger(CompletableFutureController.class);

    private final CompletableFutureService completableFutureService;
    @Autowired
    public CompletableFutureController(CompletableFutureService completableFutureService) {
        this.completableFutureService = completableFutureService;
    }

    @GetMapping("/synchronousCalled/findStudentByCity/{city}")
    public List<Student> synchronousCalled(@PathVariable String city) {
        long syncStartTime = System.currentTimeMillis();
        logger.info(" **** Start Synchronous Execution Time : " + syncStartTime + " ****");
//		completableFutureService.synchronousExecution();
        List<Student> students=completableFutureService.synchronousExecution(city);
        long syncEndTime = System.currentTimeMillis();
        logger.info("**** End Synchronous Execution Time : " + syncEndTime + " ****");
        logger.info("**** Total Synchronous Execution Time: " + (syncEndTime - syncStartTime) + "ms" + " ****");
    return students;
    }

    @GetMapping("/asynchronousCalled/findStudentByCity/{city}")
    public List<Student> asynchronousCalled(@PathVariable String city) throws ExecutionException, InterruptedException {
        long asyncStartTime = System.currentTimeMillis();
        logger.info("**** Start Asynchronous Execution Time : " + asyncStartTime + " ****");
        CompletableFuture<List<Student>> future1 = CompletableFuture.supplyAsync(() -> completableFutureService.getAllStudentByCity(city));
        CompletableFuture<List<Course>> future2 = CompletableFuture.supplyAsync(() -> completableFutureService.getAllCourse());

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
        combinedFuture.join();
        long asyncEndTime = System.currentTimeMillis();
        logger.info("**** End Asynchronous Execution Time : " + asyncEndTime + " ****");
        logger.info("**** Total Asynchronous Execution Time: " + (asyncEndTime - asyncStartTime) + "ms" + " ****");
        List<Student> students=future1.get();
        return students;
    }

}


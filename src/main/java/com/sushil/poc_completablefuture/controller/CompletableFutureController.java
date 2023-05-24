
package com.sushil.poc_completablefuture.controller;

import com.sushil.poc_completablefuture.model.Course;
import com.sushil.poc_completablefuture.model.Student;
import com.sushil.poc_completablefuture.service.CompletableFutureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/completableFuture")
public class CompletableFutureController {

    private final CompletableFutureService completableFutureService;
    @Autowired
    public CompletableFutureController(CompletableFutureService completableFutureService) {
        this.completableFutureService = completableFutureService;
    }

    @GetMapping("/synchronousCalled")
    public void synchronousCalled() {
        long syncStartTime = System.currentTimeMillis();
        System.out.println(" **** Start Synchronous Execution Time : " + syncStartTime + " ****");
//		completableFutureService.synchronousExecution();
        completableFutureService.synchronousExecution();
        long syncEndTime = System.currentTimeMillis();
        System.out.println("**** End Synchronous Execution Time : " + syncEndTime + " ****");
        System.out.println("**** Total Synchronous Execution Time: " + (syncEndTime - syncStartTime) + "ms" + " ****");
    }

    @GetMapping("/asynchronousCalled")
    public void asynchronousCalled() {
        long asyncStartTime = System.currentTimeMillis();
        System.out.println("**** Start Asynchronous Execution Time : " + asyncStartTime + " ****");
        CompletableFuture<List<Student>> future1 = CompletableFuture.supplyAsync(() -> completableFutureService.getAllStudent());
        CompletableFuture<List<Course>> future2 = CompletableFuture.supplyAsync(() -> completableFutureService.getAllCourse());

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
        combinedFuture.join();
        long asyncEndTime = System.currentTimeMillis();
        System.out.println("**** End Asynchronous Execution Time : " + asyncEndTime + " ****");
        System.out.println("**** Total Asynchronous Execution Time: " + (asyncEndTime - asyncStartTime) + "ms" + " ****");
    }

}


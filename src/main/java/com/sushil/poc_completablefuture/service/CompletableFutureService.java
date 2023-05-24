package com.sushil.poc_completablefuture.service;

import com.sushil.poc_completablefuture.model.Course;
import com.sushil.poc_completablefuture.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class CompletableFutureService {

    /*@Autowired
    private RestTemplate restTemplate;*/

    public List<Student> getAllStudent() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Student>> response = restTemplate.exchange("http://localhost:7777/api/student/", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Student>>() {
                });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" getAllCourse executed => data => " + response.getBody());
        return response.getBody();
    }


    public List<Course> getAllCourse() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Course>> response = restTemplate.exchange("http://localhost:6666/api/course/", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Course>>() {
                });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" getAllCourse executed => data => " + response.getBody());
        return response.getBody();
    }

    /* public CompletableFuture<List<Student>> callStudentAsync() {
         return CompletableFuture.supplyAsync(() -> {
             long startTime = System.currentTimeMillis();

             ResponseEntity<List<Student>> response = restTemplate.exchange("http://localhost:7777/api/student/", HttpMethod.GET, null,
                     new ParameterizedTypeReference<List<Student>>() {
                     });
             System.out.println("responce : " + response.getBody());
             List<Student> students = response.getBody();
             long endTime = System.currentTimeMillis();
             long executionTime = endTime - startTime;
             System.out.println("student service execution time : " + executionTime);
             return students;
         });
     }

     public CompletableFuture<List<Course>> callCourseAsync() {
         return CompletableFuture.supplyAsync(() -> {
             long startTime = System.currentTimeMillis();

             ResponseEntity<List<Course>> response = restTemplate.exchange("http://localhost:6666/api/course/", HttpMethod.GET, null,
                     new ParameterizedTypeReference<List<Course>>() {
                     });
             System.out.println("responce : " + response.getBody());
             List<Course> students = response.getBody();
             long endTime = System.currentTimeMillis();
             long executionTime = endTime - startTime;
             System.out.println("course service execution time : " + executionTime);
             return students;
         });
     }

 */
    public void getCityNames() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getCityNames executed.");
    }

    public void getCityPinCode() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getCityPinCode executed.");
    }

  /*  public void synchronousExecution() {
        getCityNames();
        getCityPinCode();
    }*/

    public List<Integer> getCityPinCodeWithReturnValue() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getCityPinCode executed.");
        return Arrays.asList(1234, 4321, 3456, 6534, 9969, 1303);
    }

    //    public List<String> getCityNames(){
    public List<String> getCityNamesWithReturnValue() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getCityNames executed.");
        return Arrays.asList("Lucknow", "Agra", "Kanpur", "Unnao", "Barabanki", "Mirzapur");
    }

    public void synchronousExecution() {
   /*     List<String> cities = getCityNamesWithReturnValue();
        List<Integer> pinCodes = getCityPinCodeWithReturnValue();*/
        List<Student> students = getAllStudent();
        List<Course> course = getAllCourse();
    }


}

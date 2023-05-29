package com.sushil.poc_completablefuture.service;

import com.sushil.poc_completablefuture.controller.CompletableFutureController;
import com.sushil.poc_completablefuture.external_service.CourseServiceCall;
import com.sushil.poc_completablefuture.external_service.StudentServiceCall;
import com.sushil.poc_completablefuture.model.Course;
import com.sushil.poc_completablefuture.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CompletableFutureService {
    private static final Logger logger = LoggerFactory.getLogger(CompletableFutureService.class);
    @Autowired
    public StudentServiceCall studentServiceCallUsingFeignClient;
    @Autowired
    public CourseServiceCall courseServiceCallUsingFeignClient;

    public CompletableFutureService() {
    }

    public List<Student> getAllStudent() {
        RestTemplate restTemplate = new RestTemplate();
        logger.info("thread name for get all student : " + Thread.currentThread().getName());
        ResponseEntity<List<Student>> response = restTemplate.exchange("http://localhost:7777/api/student/", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Student>>() {
                });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(" getAllCourse executed => data => " + response.getBody());
        return response.getBody();
    }


    public List<Course> getAllCourse() {
        RestTemplate restTemplate = new RestTemplate();
        logger.info("thread name for get all course : " + Thread.currentThread().getName());
       /*ResponseEntity<List<Course>> response = restTemplate.exchange("http://localhost:6666/api/course/", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Course>>() {
                });*/
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" getAllCourse executed => data => " + courseServiceCallUsingFeignClient.getAllCourse());
        return courseServiceCallUsingFeignClient.getAllCourse();
//        return response.getBody();
    }

    public void getCityNames() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("getCityNames executed.");
    }

    public void getCityPinCode() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("getCityPinCode executed.");
    }

    public List<Integer> getCityPinCodeWithReturnValue() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("getCityPinCode executed.");
        return Arrays.asList(1234, 4321, 3456, 6534, 9969, 1303);
    }

    public List<Student> synchronousExecution(String city) {
//        List<Student> students = getAllStudent();
        List<Student> students = getAllStudentByCity(city);
        List<Course> course = getAllCourse();
        return students;
    }

    /* TODO craete method to call student service->findByCity with using restTemplate with parameter */
    public List<Student> getAllStudentByCity(String city) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*start RestTemplate*/
        /*String url = "http://localhost:7777/api/student/findByCity/{city}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("city", city);

        ResponseEntity<List<Student>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Student>>() {
                }, uriVariables);*/
        /*end RestTemplate*/
        List<Student> students = new ArrayList<>();
        studentServiceCallUsingFeignClient.getAllStudentByCity(city);
        students = studentServiceCallUsingFeignClient.getAllStudentByCity(city);
//       students = response.getBody();
        return students;
    }
}

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompletableFutureService {

    public List<Student> getAllStudent() {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("thread name for get all student : " + Thread.currentThread().getName());
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
        System.out.println("thread name for get all course : " + Thread.currentThread().getName());
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

    public List<Integer> getCityPinCodeWithReturnValue() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getCityPinCode executed.");
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
        String url = "http://localhost:7777/api/student/findByCity/{city}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("city", city);

        ResponseEntity<List<Student>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Student>>() {
                }, uriVariables);
        List<Student> students = response.getBody();
        return students;
    }
}

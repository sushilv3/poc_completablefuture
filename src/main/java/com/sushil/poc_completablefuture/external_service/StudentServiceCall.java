package com.sushil.poc_completablefuture.external_service;

import com.sushil.poc_completablefuture.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "http://localhost:7777/api/student")
public interface StudentServiceCall {
    @GetMapping("/")
    public List<Student> getAllStudent();
    @GetMapping("/findByCity/{city}")
    public List<Student> getAllStudentByCity(@PathVariable String city);
}

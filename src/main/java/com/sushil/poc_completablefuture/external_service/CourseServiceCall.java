package com.sushil.poc_completablefuture.external_service;

import com.sushil.poc_completablefuture.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "course-service",url = "http://localhost:6666/api/course")
public interface CourseServiceCall {

    @GetMapping("/")
    public List<Course> getAllCourse();
}

package org.example.poly.api;

import org.example.poly.model.request.CourseRequest;
import org.example.poly.service.CloudinaryService;
import org.example.poly.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/course")
public class CourseApi {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping
    public ResponseEntity<Object> getAllCourse(
            @RequestParam("pageCurrent")  Integer pageCurrent,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("sortOrder") String sortOrder,
            @RequestParam("sortBy") String sortBy
    ) {
        Map<String,Object> result = new HashMap<>();
        Sort sort = Sort.by(new Sort.Order(Objects.equals(sortOrder, "asc") ? Sort.Direction.ASC : Sort.Direction.DESC , sortBy));
        Pageable pageable  = PageRequest.of(pageCurrent, pageSize, sort);
        System.out.println("pageable " + pageable);
        try {
            result.put("success",true);
            result.put("message" , "get ALl Course");
            result.put("data",courseService.getAllCourse(pageable));
        }catch (Exception e){
            result.put("success",false);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/byId/{courseId}")
    public ResponseEntity<Object> getCourseById(
            @PathVariable("courseId") Integer courseId
    ) {
        Map<String,Object> result = new HashMap<>();
        try {
            result.put("success",true);
            result.put("message" , "get  Course By Id");
            result.put("data",courseService.getCourseById(courseId));
        }catch (Exception e){
            result.put("success",false);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Object> createCourse(
            @RequestPart("courseRequest") CourseRequest courseRequest,
            @RequestPart("files") MultipartFile [] files
            ) throws IOException {
        Map<String,Object> result = new HashMap<>();
        if (files != null){
            System.out.println("Co Image");
            courseRequest.setImageUrl(cloudinaryService.uploadFile(files, "course").get(0));
        }else {
            courseRequest.setImageUrl("");
        }
        try {
            result.put("success",true);
            result.put("message" , "Create  Course");
            result.put("data",courseService.createCourse(courseRequest));
        }catch (Exception e){
            result.put("success",false);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }


    @PutMapping("/{courseId}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'TEACHER')")
    public ResponseEntity<Object> updateCourse(
            @PathVariable("courseId") Integer courseId,
            @RequestPart("files") MultipartFile [] files,
            @RequestPart("courseRequest")CourseRequest courseRequest
    ) throws IOException {
        Map<String,Object> result = new HashMap<>();
        if (files != null){
            System.out.println("Co Image");
            courseRequest.setImageUrl(cloudinaryService.uploadFile(files, "course").get(0));
        }else {
            courseRequest.setImageUrl("");
        }
        try {
            result.put("success",true);
            result.put("message" , "update Course");
            result.put("data",courseService.updateCourse(courseId,courseRequest));
        }catch (Exception e){
            result.put("success",false);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }
}

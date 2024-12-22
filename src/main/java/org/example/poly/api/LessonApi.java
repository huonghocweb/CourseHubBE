package org.example.poly.api;

import java.util.HashMap;
import java.util.Map;

import org.example.poly.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/lesson")
public class LessonApi {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/getByCourseId/{courseId}")
    public ResponseEntity<Object> getLessonByCourseId(@PathVariable("courseId") Integer courseId) {
        Map<String,Object> result = new HashMap<>();
        System.out.println("courseId" + courseId);
        try {

            result.put("success", true);
            result.put("message", "get Lessons BY Course Id");
            result.put("data", lessonService.getLessonByCourseId(courseId));
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/getById/{lessonId}")
    public ResponseEntity<Object> getLessonById(@PathVariable("lessonId") Integer lessonId) {
        Map<String,Object> result = new HashMap<>();
        try {
            result.put("success", true);
            result.put("message", "get Lessons BY  Id");
            result.put("data", lessonService.getLessonById(lessonId));
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }
    
}

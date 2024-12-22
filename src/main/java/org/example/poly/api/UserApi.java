package org.example.poly.api;

import org.example.poly.model.request.UserRequest;
import org.example.poly.model.response.UserResponse;
import org.example.poly.service.CloudinaryService;
import org.example.poly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    private UserService userService;
    @Autowired
    private CloudinaryService cloudinaryService;


    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllUser(
            @RequestParam("pageCurrent") Integer pageCurrent,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("sortOrder") String sortOrder,
            @RequestParam("sortBy") String sortBy
    ){
        Map<String,Object> result = new HashMap<>();
        Sort sort = Sort.by(new Sort.Order(Objects.equals("asc", sortOrder) ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));
        Pageable pageable = PageRequest.of(pageCurrent, pageSize, sort);
        try {
            result.put("success", "true");
            result.put("message", "Get All User");
            result.put("data",userService.getAllUser(pageable));
        }catch (Exception e){
            result.put("success", "false");
            result.put("message", e.getMessage());
            result.put("data",null);
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/getByUserName/{userName}")
    public ResponseEntity<Object> getUserByUserName(
            @PathVariable("userName") String userName
    ){
        Map<String,Object> result = new HashMap<>();
        try {
            result.put("success", "true");
            result.put("message", "Get User By userName");
            result.put("data",userService.getUserByUserName(userName));
        }catch (Exception e){
            result.put("success", "false");
            result.put("message", e.getMessage());
            result.put("data",null);
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping
        public ResponseEntity<Object> createUser(
                @RequestPart("userRequest") UserRequest userRequest,
                @RequestPart(value = "files",required = false) MultipartFile [] files
                ) throws IOException {
            Map<String,Object> result = new HashMap<>();
            if(files != null ){
                userRequest.setImageUrl(cloudinaryService.uploadFile(files, "user").get(0));
            }else {
                userRequest.setImageUrl("");
            }
            try {
                result.put("success", "true");
                result.put("message", "Create  User");
                result.put("data",userService.createUser(userRequest));
            }catch (Exception e){
                result.put("success", "false");
                result.put("message", e.getMessage());
                result.put("data",null);
            }
            return ResponseEntity.ok(result);
        }

        @PutMapping("/{userId}")
        public ResponseEntity<Object> updateUser(
                @PathVariable("userId") Integer userId ,
                @RequestPart("userRequest") UserRequest userRequest,
                @RequestPart(value = "files",required = false) MultipartFile[] files
        ) throws IOException {
            Map<String,Object> result = new HashMap<>();
            if(files !=null){
                userRequest.setImageUrl(cloudinaryService.uploadFile(files, "user").get(0));
            }else {
                UserResponse user = userService.getUserById(userId);
                userRequest.setImageUrl(user.getImageUrl());
            }
            try {
                result.put("success", "true");
                result.put("message", "Update User");
                result.put("data",userService.updateUser( userRequest , userId));
            }catch (Exception e){
                result.put("success", "false");
                result.put("message", e.getMessage());
                result.put("data",null);
            }
            return ResponseEntity.ok(result);
        }


    @GetMapping("/getById/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable("userId") int userId) {
        Map<String,Object> result = new HashMap<>();
        try {
            result.put("success", true);
            result.put("message", "get User By id");
            result.put("data" , userService.getUserById(userId));
        }catch (Exception e) {
            result.put("success", false);
            result.put("message",e.getMessage());
            result.put("data" , null);
        }
        return  ResponseEntity.ok(result);
    }


}

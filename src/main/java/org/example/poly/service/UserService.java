package org.example.poly.service;

import org.example.poly.model.request.UserRequest;
import org.example.poly.model.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
  Page<UserResponse> getAllUser(Pageable pageable);

  UserResponse getUserById(Integer id);

  UserResponse createUser(UserRequest userRequest);

  UserResponse updateUser(UserRequest userRequest, Integer id);

  Void deleteUserById(Integer id);

  UserResponse getUserByUserName(String username);
}

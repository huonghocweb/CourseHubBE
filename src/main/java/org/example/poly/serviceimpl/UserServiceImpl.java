package org.example.poly.serviceimpl;

import jakarta.persistence.EntityNotFoundException;
import org.example.poly.model.entity.User;
import org.example.poly.mapper.UserMapper;
import org.example.poly.model.request.UserRequest;
import org.example.poly.repo.RoleRepo;
import org.example.poly.repo.UserRepo;
import org.example.poly.model.response.UserResponse;
import org.example.poly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Page<UserResponse> getAllUser(Pageable pageable) {
        Page<User> usersPage = userRepo.findAll(pageable);
        if (pageable.getPageNumber() >= (usersPage.getTotalPages() - 1)) {
            pageable = PageRequest.of(usersPage.getTotalPages() - 1, pageable.getPageSize(), pageable.getSort());
        }
        List<UserResponse> userResponses = usersPage.getContent().stream()
                .map(userMapper::convertEnToRes)
                .collect(Collectors.toList());
        return new PageImpl<>(userResponses, pageable, usersPage.getTotalElements());
    }

    @Override
    public UserResponse getUserById(Integer id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found User"));
        return userMapper.convertEnToRes(user);
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = userMapper.convertReqToEn(userRequest);
        System.out.println("User: " + user);
        // Mã hóa mật khẩu trước khi lưu
        user.setRoles(userRequest.getRoleIds() != null ? userRequest.getRoleIds().stream()
                .map(roleId -> roleRepo.findById(roleId)
                        .orElseThrow(() -> new EntityNotFoundException("not found Role")))
                .collect(Collectors.toList()) : null);
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userUpdate = userRepo.save(user);
        return userMapper.convertEnToRes(userUpdate);
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, Integer id) {
        return userRepo.findById(id).map(us -> {
            User user = userMapper.convertReqToEn(userRequest);
            user.setRoles(userRequest.getRoleIds() != null ? userRequest.getRoleIds().stream()
                    .map(roleId -> roleRepo.findById(roleId)
                            .orElseThrow(() -> new EntityNotFoundException("not found Role")))
                    .collect(Collectors.toList()) : null);
            user.setUserId(us.getUserId());
            // user.setPassword(passwordEncoder.encode(user.getPassword()));
            User userUpdate = userRepo.save(user);
            return userMapper.convertEnToRes(userUpdate);
        }).orElseThrow(() -> new EntityNotFoundException("Not Found User By Id"));
    }

    @Override
    public Void deleteUserById(Integer id) {
        Optional<User> user = userRepo.findById(id);
        user.ifPresent(value -> userRepo.save(value));
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public UserResponse getUserByUserName(String username) {
        User user = userRepo.getUserByUserName(username);

        return userMapper.convertEnToRes(user);
    }
}

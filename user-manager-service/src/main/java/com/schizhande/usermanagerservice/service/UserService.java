package com.schizhande.usermanagerservice.service;

import com.schizhande.usermanagerservice.dto.CreateUserRequest;
import com.schizhande.usermanagerservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Collection;

public interface UserService {
    User createUser(CreateUserRequest createUserRequest);

    User updateUser(CreateUserRequest createUserRequest);

    User findById(Long userId);

    void deleteUser(Long userId);

    Collection<User> findAll();

    Page<User> findAll(PageRequest pageRequest, String search);
}

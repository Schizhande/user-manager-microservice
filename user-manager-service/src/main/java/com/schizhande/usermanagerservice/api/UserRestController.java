package com.schizhande.usermanagerservice.api;


import com.schizhande.usermanagerservice.dto.CreateUserRequest;
import com.schizhande.usermanagerservice.model.User;
import com.schizhande.usermanagerservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@Api(tags = "User APIs")
@RequestMapping("/v1/users")
public class UserRestController {

    private final UserService userService;

    @PostMapping
    @ApiOperation(value = "Create user")
    public User createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }

    @PutMapping("/{userId}")
    @ApiOperation(value = "Update user")
    public User updateUser(@PathVariable Long userId, @RequestBody CreateUserRequest createUserRequest) {
        createUserRequest.setId(userId);
        return userService.updateUser(createUserRequest);
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "Get one user")
    public User getUserById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @DeleteMapping("/{userId}")
    @ApiOperation(value = "Delete user")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all users")
    public Collection<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{page}/{size}")
    @ApiOperation(value = "Get all paginated users")
    public Page<User> getAll(@PathVariable int page, @PathVariable int size, @RequestParam(required = false) String search) {
        return userService.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createTimeStamp")),
                search);
    }

}

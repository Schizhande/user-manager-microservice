package com.schizhande.usermanagerservice.service;

import com.schizhande.usermanagerservice.dao.UserRepository;
import com.schizhande.usermanagerservice.dao.jpa.CustomSpecificationTemplateImplBuilder;
import com.schizhande.usermanagerservice.dto.CreateUserRequest;
import com.schizhande.usermanagerservice.exceptions.RecordNotFoundException;
import com.schizhande.usermanagerservice.model.User;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;

import static com.schizhande.usermanagerservice.utils.FieldsValidator.validate;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(CreateUserRequest createUserRequest) {

        validate(createUserRequest);

        val user = User.fromRequest(createUserRequest);

        user.setCreateTimeStamp(Timestamp.valueOf(LocalDateTime.now()));

        return userRepository.save(user);
    }

    @Override
    public User updateUser(CreateUserRequest createUserRequest) {

        validate(createUserRequest);

        val user = findById(createUserRequest.getId());

        user.update(createUserRequest);

        return userRepository.save(user);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RecordNotFoundException("User with id " + userId + " not found"));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(PageRequest pageRequest, String search) {
        if (isNull(search)) {
            return userRepository.findAll(pageRequest);
        } else {
            Specification<User> spec = (new CustomSpecificationTemplateImplBuilder<User>())
                    .buildSpecification(search);
            return userRepository.findAll(spec, pageRequest);
        }
    }
}

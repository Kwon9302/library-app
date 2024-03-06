package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceV2 {

    private final UserRepository userRepository;

    // 아래있는 함수가 시작될때 start transaction을 해준다 (트랙잭션을 시작)
    // 함수가 예외없이 잘 끝났다면 commit
    // 문제가 있다면 rollback -> 저장 자체가 안됨
    @Transactional
    public void saveUser(UserCreateRequest request) {
        userRepository.save(new User(request.getName(), request.getAge()));
    }
    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        user.updateName(request.getName());
        userRepository.save(user);
    }
    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findByName(name);

        if (user == null) {
            throw new IllegalArgumentException();
        }
        userRepository.delete(user);
    }

}

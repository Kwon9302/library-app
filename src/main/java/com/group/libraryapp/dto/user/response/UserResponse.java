package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.user.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserResponse {
    private long id;
    private String name;

    private int age;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public UserResponse(long id, User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }
}

package it.konvergence.myproject.service;


import it.konvergence.myproject.entity.User;
import it.konvergence.myproject.request.UserDto;

import java.util.List;

public interface UserService {
    User saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}

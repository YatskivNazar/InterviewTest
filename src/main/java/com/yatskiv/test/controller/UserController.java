package com.yatskiv.test.controller;

import com.yatskiv.test.converter.UserEntityToDTOConverter;
import com.yatskiv.test.dto.UserDTO;
import com.yatskiv.test.entity.User;
import com.yatskiv.test.service.UserService;
import com.yatskiv.test.util.Color;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("${user.url.prefix}")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/age/{age}")
    public List<UserDTO> getAllByAgeIsGreaterThan(@PathVariable Integer age){
        return UserEntityToDTOConverter.convertUsersToDTO(userService.getAllByAgeIsGreaterThan(age));
    }

    @GetMapping("/articles/count/{count}")
    public Set<String> getUniqueNamesOfUsersArticlesCountIsGreaterThan(@PathVariable Integer count){
        return userService.getUniqueNamesWhereArticlesCountIsGreaterThan(count);
    }

    @GetMapping("/articles/color/{color}")
    public Set<UserDTO> getUsersByArticleColor(@PathVariable Color color){
        return UserEntityToDTOConverter.convertUsersToDTO(userService.getUsersByArticleColor(color));
    }

    @PutMapping("/users/{id}")
    public User replaceUser(@RequestBody User user, @PathVariable Long id){
        return userService.saveOrUpdate(user, id);
    }

}

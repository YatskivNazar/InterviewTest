package com.yatskiv.test.service;

import com.yatskiv.test.entity.User;
import com.yatskiv.test.util.Color;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    List<User> getAllByAgeIsGreaterThan(Integer age);
    Set<String> getUniqueNamesWhereArticlesCountIsGreaterThan(Integer count);
    Set<User> getUsersByArticleColor(Color color);
    User saveOrUpdate(User newUser, Long id);
    Optional<User> getById(Long id);
    void saveAllUsers(List<User> users);
}

package com.yatskiv.test.service.impl;

import com.yatskiv.test.entity.User;
import com.yatskiv.test.repository.UserRepository;
import com.yatskiv.test.service.UserService;
import com.yatskiv.test.util.Color;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllByAgeIsGreaterThan(Integer age) {
        return userRepository.findAllByAgeIsGreaterThan(age);
    }

    @Override
    public Set<String> getUniqueNamesWhereArticlesCountIsGreaterThan(Integer count) {
        return userRepository.findUniqueNamesWhereArticlesIsGreaterThan(count);
    }

    @Override
    public Set<User> getUsersByArticleColor(Color color) {
        return userRepository.findAllByArticlesContainsCColor(color);
    }

    public void saveAllUsers(List<User> users){
        userRepository.saveAll(users);
    }

    @Override
    public User saveOrUpdate(User newUser, Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setAge(newUser.getAge());
                    user.setName(newUser.getName());
                    user.setArticles(newUser.getArticles());
                    return userRepository.save(user);
                }).orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
}

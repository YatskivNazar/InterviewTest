package com.yatskiv.test;

import com.yatskiv.test.entity.Article;
import com.yatskiv.test.entity.User;
import com.yatskiv.test.service.UserService;
import com.yatskiv.test.util.Color;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> userList = createUsers();
        userService.saveAllUsers(userList);
    }

    private List<User> createUsers() {
        return Arrays.asList(
                    new User("first", 20, Arrays.asList(
                            new Article("first user - article 1", Color.BLACK),
                            new Article("first user - article 2", Color.BLUE),
                            new Article("first user - article 4", Color.RED),
                            new Article("first user - article 5", Color.RED),
                            new Article("first user - article 6", Color.WHITE))
                    ),
                    new User("second", 30, Arrays.asList(
                            new Article("second user - article 1", Color.WHITE),
                            new Article("second user - article 2", Color.GREEN),
                            new Article("second user - article 4", Color.RED),
                            new Article("second user - article 5", Color.BLACK),
                            new Article("second user - article 6", Color.RED),
                            new Article("second user - article 7", Color.GREEN))
                    ),
                    new User("third", 31, Arrays.asList(
                            new Article("third user - article 1", Color.RED))
                    ),
                    new User("fourth", 29, Arrays.asList(
                            new Article("fourth user - article 2", Color.WHITE),
                            new Article("fourth user - article 3", Color.BLACK))
                    ),
                    new User("fifth", 20, Arrays.asList(
                            new Article("fifth user - article 1", Color.RED),
                            new Article("fifth user - article 2", Color.BLUE))
                    ),
                    new User("sixth", 20, Arrays.asList(
                            new Article("sixth user - article 1", Color.BLACK),
                            new Article("sixth user - article 2", Color.WHITE),
                            new Article("sixth user - article 4", Color.GREEN),
                            new Article("sixth user - article 5", Color.RED),
                            new Article("sixth user - article 6", Color.RED))
                    ),
                    new User("seventh", 30, Arrays.asList(
                            new Article("seventh user - article 1", Color.BLUE),
                            new Article("seventh user - article 2", Color.WHITE),
                            new Article("seventh user - article 4", Color.RED),
                            new Article("seventh user - article 5", Color.BLUE))
                    ),
                    new User("eights", 20, Arrays.asList(
                            new Article("eights user - article 1", Color.GREEN),
                            new Article("eights user - article 2", Color.BLUE),
                            new Article("eights user - article 5", Color.BLACK),
                            new Article("eights user - article 6", Color.GREEN))
                    ),
                    new User("ninth", 30, Arrays.asList(
                            new Article("ninth user - article 1", Color.BLACK),
                            new Article("ninth user - article 2", Color.BLACK),
                            new Article("ninth user - article 4", Color.GREEN),
                            new Article("ninth user - article 5", Color.WHITE))
                    ),
                    new User("tenth", 18, Arrays.asList(
                            new Article("tenth user - article 1", Color.BLACK))
                    )
            );
    }
}
